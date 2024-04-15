package com.igor_shaula.complex_api_client_sample

import com.igor_shaula.complex_api_client_sample.domain.GenericErrorForUI
import com.igor_shaula.complex_api_client_sample.fakes.FakeDataSource
import com.igor_shaula.complex_api_client_sample.fakes.FakeVehiclesRepository
import com.igor_shaula.complex_api_client_sample.fakes.mockResponseWithEmptyData
import com.igor_shaula.complex_api_client_sample.fakes.mockResponseWithFullData
import com.igor_shaula.complex_api_client_sample.rules.VMTestWatcher
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel
import com.igor_shaula.complex_api_client_sample.ui.TheUiState
import com.igor_shaula.complex_api_client_sample.ui.models.toVehicleModels
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

/*
A good test strategy revolves around covering different paths and boundaries of your code.
At a very basic level, you can categorize the tests in three scenarios:
success path, error path, and boundary case.

A good unit test typically has following four properties:

Focused:
It should focus on testing a unit, such as a piece of code.
This piece of code is often a class or a method.
The test should be narrow and focus on validating the correctness of individual pieces of code,
rather than multiple pieces of code at the same time.

Understandable:
It should be simple and easy to understand when you read the code.
At a glance, a developer should be able to immediately understand the intention behind the test.

Deterministic:
It should consistently pass or fail. When you run the tests any number of times,
without making any code changes, the test should yield the same result.
The test shouldn't be flaky,
with a failure in one instance and a pass in another instance despite no modification to the code.

Self-contained:
It does not require any human interaction or setup and runs in isolation.
 */
class MainViewModelTests {

    @get:Rule
    val textWatcher = VMTestWatcher()

// 1 - testing initialization of the ViewModel

    @Test
    fun init_viewModelCreated_viewModelIsReady() {
        val viewModel = MainViewModel(FakeVehiclesRepository())
        Assert.assertEquals("", viewModel.searchQueryForUI)
        Assert.assertEquals("", viewModel.searchQuery)
        Assert.assertEquals(TheUiState.FreshStart, viewModel.uiState)
    }

// 2 - testing how error states are processed

    @Test
    fun setupForCatchingAnyErrorInfo_emitAnError_errorStateIsActive() = runTest {
        val fakeRepository = FakeVehiclesRepository()
        val viewModel = MainViewModel(fakeRepository)
        fakeRepository.errorDataForTest.emit(GenericErrorForUI("errorInfo"))
//        fakeRepository.errorDataForTest.value = GenericErrorForUI("errorInfo") // also works
        Assert.assertEquals("", viewModel.searchQueryForUI)
        Assert.assertEquals("", viewModel.searchQuery)
        Assert.assertEquals(
            TheUiState.Error("errorInfo").errorInfo,
            (viewModel.uiState as TheUiState.Error).errorInfo
        )
        Assert.assertEquals(
            TheUiState.Error("").javaClass, viewModel.uiState.javaClass
        )
    }

// 3 - testing updateSearchRequestTested() with all possible arguments

    // isForced = false & newQuery = " " -> request should not be sent - empty typing case
    @Test
    fun updateSearchRequest_searchEmptyQuery_requestIsNotSent() {
        val viewModel = MainViewModel(
            FakeVehiclesRepository(FakeDataSource(mockResponseWithEmptyData))
        )
        viewModel.updateSearchRequestTested(newText = " ", isForced = false)
        Assert.assertEquals(" ", viewModel.searchQueryForUI) // only UI has to be updated
        Assert.assertEquals("", viewModel.searchQuery) // remains empty for all blank symbols
        Assert.assertEquals(TheUiState.FreshStart, viewModel.uiState)
    }

    // isForced = true & newQuery = " " -> request should be sent - checking connection case
    @Test
    fun updateSearchRequest_forcedClickAndEmptySearchQuery_requestIsSent() {
        val viewModel = MainViewModel(
            FakeVehiclesRepository(FakeDataSource(mockResponseWithEmptyData))
        )
        viewModel.updateSearchRequestTested(newText = " ", isForced = true)
        Assert.assertEquals(" ", viewModel.searchQueryForUI)
        Assert.assertEquals("", viewModel.searchQuery)
        Assert.assertEquals(TheUiState.EmptyList, viewModel.uiState)
    }

    // isForced = false & newQuery = "good" -> request should be sent - normal case
    @Test
    fun updateSearchRequest_searchValidQuery_requestIsSent() = runTest {
        val fakeRepository = FakeVehiclesRepository(FakeDataSource(mockResponseWithFullData))
        val viewModel = MainViewModel(fakeRepository)
        viewModel.updateSearchRequestTested(newText = "good", isForced = false)
        Assert.assertEquals("good", viewModel.searchQueryForUI)
        Assert.assertEquals("good", viewModel.searchQuery)
        val expectedList =
            fakeRepository.launchSearchRequestFor("good").toVehicleModels()
        Assert.assertEquals(expectedList, (viewModel.uiState as TheUiState.Success).theList)
        Assert.assertEquals(
            TheUiState.Success(expectedList).javaClass, viewModel.uiState.javaClass
        )
    }

    // isForced = true & newQuery = "good" -> request should be sent - forced repetition case
    @Test
    fun updateSearchRequest_forcedClickAndValidSearchQuery_requestIsSent() = runTest {
        val fakeRepository = FakeVehiclesRepository(FakeDataSource(mockResponseWithFullData))
        val viewModel = MainViewModel(fakeRepository)
        viewModel.updateSearchRequestTested(newText = "good", isForced = true)
        Assert.assertEquals("good", viewModel.searchQueryForUI)
        Assert.assertEquals("good", viewModel.searchQuery) // as a previous value
        val expectedList =
            fakeRepository.launchSearchRequestFor("good").toVehicleModels()
        Assert.assertEquals(expectedList, (viewModel.uiState as TheUiState.Success).theList)
        Assert.assertEquals(
            TheUiState.Success(expectedList).javaClass, viewModel.uiState.javaClass
        )
    }

    // isForced = false & newQuery = " good " -> request should not be sent
    @Test
    fun updateSearchRequest_searchValidQueryWithEdgeBlanks_requestIsNotSent() = runTest {
        val fakeRepository = FakeVehiclesRepository(FakeDataSource(mockResponseWithFullData))
        val viewModel = MainViewModel(fakeRepository)
        viewModel.updateSearchRequestTested(newText = "good", isForced = false)
        viewModel.updateSearchRequestTested(newText = " good ", isForced = false)
        Assert.assertEquals(" good ", viewModel.searchQueryForUI)
        Assert.assertEquals("good", viewModel.searchQuery)
        val expectedList =
            fakeRepository.launchSearchRequestFor("good").toVehicleModels()
        Assert.assertEquals(expectedList, (viewModel.uiState as TheUiState.Success).theList)
        Assert.assertEquals(
            TheUiState.Success(expectedList).javaClass, viewModel.uiState.javaClass
        )
    }

    // isForced = true & newQuery = " good " -> request should be sent
    @Test
    fun updateSearchRequest_forcedClickAndValidSearchQueryWithEdgeBlanks_requestIsSent() = runTest {
        val fakeRepository = FakeVehiclesRepository(FakeDataSource(mockResponseWithFullData))
        val viewModel = MainViewModel(fakeRepository)
        viewModel.updateSearchRequestTested(newText = "good", isForced = true)
        viewModel.updateSearchRequestTested(newText = " good ", isForced = true)
        Assert.assertEquals(" good ", viewModel.searchQueryForUI)
        Assert.assertEquals("good", viewModel.searchQuery)
        val expectedList =
            fakeRepository.launchSearchRequestFor("good").toVehicleModels()
        Assert.assertEquals(expectedList, (viewModel.uiState as TheUiState.Success).theList)
        Assert.assertEquals(
            TheUiState.Success(expectedList).javaClass, viewModel.uiState.javaClass
        )
    }
}
