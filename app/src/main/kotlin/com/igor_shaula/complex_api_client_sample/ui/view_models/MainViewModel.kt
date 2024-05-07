package com.igor_shaula.complex_api_client_sample.ui.view_models

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor_shaula.complex_api_client_sample.data.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.ui.models.toTheUiModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val vehiclesRepository: VehiclesRepository
) : ViewModel() {

    var uiState: MainUiState by mutableStateOf(MainUiState.FreshStart)
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
    }

    // this method is used only to handle @VisibleForTesting warning without @Suppress on higher level
    fun updateSearchRequest(newText: String, isForced: Boolean) =
        updateSearchRequestTested(newText, isForced) // this line should not be counted in coverage

    private fun setupForCatchingAnyErrorInfo() {
        viewModelScope.launch {
            vehiclesRepository.errorData.collect {
                if (it.explanation != null) {
                    uiState = MainUiState.Error(it.explanation)
                }
                println("repository.errorData.collect: ${it.explanation}")
            }
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
            val resultList = vehiclesRepository.launchSearchRequestFor(searchQuery)
            println("updateSearchRequest: resultList.size = ${resultList.size}")
            val vehiclesList = resultList.toTheUiModels()
            uiState = if (vehiclesList.isEmpty()) {
                MainUiState.EmptyList
            } else {
                MainUiState.Success(vehiclesList)
            }
        }
    }
}