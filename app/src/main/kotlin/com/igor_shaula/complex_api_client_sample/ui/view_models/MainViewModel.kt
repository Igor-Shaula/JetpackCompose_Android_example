package com.igor_shaula.complex_api_client_sample.ui.view_models

import androidx.annotation.VisibleForTesting
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.data.repositories.BeersRepository
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import com.igor_shaula.complex_api_client_sample.data.repositories.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.ui.models.fromBeersToTheUiModels
import com.igor_shaula.complex_api_client_sample.ui.models.toTheUiModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val vehiclesRepository: VehiclesRepository,
    private val settingsRepository: SettingsRepository,
    private val beersRepository: BeersRepository
) : ViewModel() {

    var uiState: MainUiState by mutableStateOf(
        MainUiState.FreshStart(settingsRepository.activeApiStateFlow.value)
    )
        private set

    // used only in TopBar UI and is needed to make uiState much simpler then if it was a part of uiState
    var searchQueryForUI by mutableStateOf("")
        private set

    @VisibleForTesting
    // actual data for the network request - clean from blank symbols - may be different from searchQueryForUI
    internal var searchQuery = ""

    // we need this reference because the job can be still running when a new request is needed to start
    private var getTheNewListJob: Job? = null

    init {
        setupForCatchingAnyErrorInfo()
        listenActiveApiStateFlow()
//        listenActiveApiSharedFlow() // experiment
//        listenActiveApiChannel() // also experiment
//        listenActiveApiMLD()
    }

    // this method is used only to handle @VisibleForTesting warning without @Suppress on higher level
    fun updateSearchRequest(newText: String, isForced: Boolean) =
        updateSearchRequestTested(newText, isForced) // this line should not be counted in coverage

    private fun setupForCatchingAnyErrorInfo() {
        viewModelScope.launch {
            vehiclesRepository.errorData.collect {
                if (it.explanation != null) {
                    uiState = MainUiState.Error(
                        it.explanation, settingsRepository.activeApiStateFlow.value
                    )
                }
                println("repository.errorData.collect: ${it.explanation}")
            }
        }
    }

    private fun listenActiveApiStateFlow() {
        viewModelScope.launch {
            settingsRepository.activeApiStateFlow.collect { activeApi ->
                println("listenActiveApiStateFlow: " + activeApi.name)
                // change API -> result from previous API is no more needed
                uiState = MainUiState.FreshStart(activeApi)
            }
        }
    }

    private fun listenActiveApiSharedFlow() {
        viewModelScope.launch {
            settingsRepository.activeApiSharedFlow.collectLatest { activeApi ->
                println("listenActiveApiSharedFlow: " + activeApi.name)
                // change API -> result from previous API is no more needed
                uiState = MainUiState.FreshStart(activeApi)
            }
        }
    }

    private fun listenActiveApiChannel() {
        viewModelScope.launch {
            settingsRepository.activeApiChannel.consumeAsFlow().collectLatest { activeApi ->
//            settingsRepository.activeApiChannel.receiveAsFlow().collectLatest { activeApi ->
                println("listenActiveApiChannel: " + activeApi.name)
                // change API -> result from previous API is no more needed
                uiState = MainUiState.FreshStart(activeApi)
            }
        }
    }

    private fun listenActiveApiMLD() {
        settingsRepository.activeApiMLD.observeForever { activeApi ->
            println("listenActiveApiChannel: " + activeApi.name)
            // change API -> result from previous API is no more needed
            uiState = MainUiState.FreshStart(activeApi)
        }
    }

    @VisibleForTesting
    internal fun updateSearchRequestTested(newText: String, isForced: Boolean) {
        println("updateSearchRequest: newText = $newText")

        // before any logic is started - users have to see what they are typing at the moment
        searchQueryForUI =
            newText // to show on UI what the user is actually typed in the Search field

        // at first it would be wise to check if the user typed spaces - in fact that would be the same query
        if (!isForced && newText.trim() == searchQuery) {
            return // just let the previous possibly running query to finish its work
        }

        // now we can update the real query data and launch the real network job
        searchQuery = newText.trim()

        // now when the new query is really different - we have to stop possible previous request
        if (getTheNewListJob?.isActive == true) {
            getTheNewListJob?.cancel() // this line will be tested after debounce technique is added
        }

        // and finally - the data request from the repository inside the VM coroutine scope (for here)
        getTheNewListJob = viewModelScope.launch {
            uiState = MainUiState.Loading
            if (settingsRepository.activeApiStateFlow.value == ActiveApi.OUTDOORSY) {
                val resultList = vehiclesRepository.launchSearchRequestFor(searchQuery)
                println("updateSearchRequest: resultList.size = ${resultList.size}")
                val vehiclesList = resultList.toTheUiModels()
                uiState = if (vehiclesList.isEmpty()) {
                    MainUiState.EmptyList(settingsRepository.activeApiStateFlow.value)
                } else {
                    MainUiState.Success(vehiclesList)
                }
            } else {
                kotlin.runCatching {
                    beersRepository.fetchBeers()
                }.onSuccess { items ->
                    val theUiModels = (items.fromBeersToTheUiModels())
                    println("onSuccess: ${theUiModels.size}")
                    uiState = if (theUiModels.isEmpty()) {
                        MainUiState.EmptyList(settingsRepository.activeApiStateFlow.value)
                    } else {
                        MainUiState.Success(theUiModels)
                    }
                }.onFailure {
                    uiState = MainUiState.Error(
                        "" + it.localizedMessage, settingsRepository.activeApiStateFlow.value
                    )
                }
            }
        }
    }

    // this function is left for the future for potential reaction for drawer state change
    fun onDrawerStateChange(drawerState: DrawerState) {
        println("onDrawerStateChange: isClosed = " + drawerState.isClosed)
        // when the main content is hidden beneath the open drawer - we can pause its progress
    }
}
