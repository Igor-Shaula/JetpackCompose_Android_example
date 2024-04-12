package com.igor_shaula.complex_api_client_sample.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.ui.models.toVehicleModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val vehiclesRepository: VehiclesRepository
) : ViewModel() {

    var uiState: TheUiState by mutableStateOf(TheUiState.FreshStart)
        private set

    // used only in TopBar UI and is needed to make uiState much simpler then if it was a part of uiState
    var searchQueryForUI by mutableStateOf("")
        private set

    // actual data for the network request - clean from blank symbols - may be different from searchQueryForUI
    private var searchQuery = ""

    // we need this reference because the job can be still running when a new request is needed to start
    private var getVehiclesJob: Job? = null

    init {
        viewModelScope.launch {
            vehiclesRepository.errorData.collect {
                if (it.explanation != null) {
                    uiState = TheUiState.Error(it.explanation)
                }
                println("repository.errorData.collect: ${it.explanation}")
            }
        }
    }

    override fun onCleared() {
        getVehiclesJob?.cancel()
        getVehiclesJob = null
        super.onCleared()
    }

    fun updateSearchRequest(newText: String, isForced: Boolean) {
        println("updateSearchRequest: newText = $newText")

        // before any logic is started - users have to see what they are typing at the moment
        searchQueryForUI =
            newText // to show on UI what the user is actually typed in the Search field

        // at first it would be wise to check if the user typed spaces - in fact that would be the same query
        if (!isForced && newText.trim() == searchQuery) {
            return // just let the previous possibly running query to finish its work
        }

        // now we can update the real query data and launch the real network job
        if (!isForced) {
            searchQuery = newText.trim()
        }

        // now when the new query is really different - we have to stop possible previous request
        if (getVehiclesJob?.isActive == true) {
            getVehiclesJob?.cancel()
        }
        getVehiclesJob = viewModelScope.launch {
            uiState = TheUiState.Loading
            val resultList = vehiclesRepository.launchSearchRequestFor(searchQuery)
            println("updateSearchRequest: resultList = $resultList")
            val vehiclesList = resultList.toVehicleModels()
            uiState = if (vehiclesList.isEmpty()) {
                TheUiState.EmptyList
            } else {
                TheUiState.Success(vehiclesList)
            }
        }
    }
}
