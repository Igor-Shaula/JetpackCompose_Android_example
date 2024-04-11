package com.igor_shaula.complex_api_client_sample.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.ui.models.toVehicleModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: VehiclesRepository

    var uiState: TheUiState by mutableStateOf(TheUiState.FreshStart)
        private set

    var searchQueryForUI by mutableStateOf("")
        private set

    private val coroutineScope = MainScope() + CoroutineName(this.javaClass.simpleName)

    private var getVehiclesJob: Job? = null

    private var searchQuery = ""

    init {
        coroutineScope.launch {
            repository.errorData.collect {
                if (it.explanation != null) {
                    uiState = TheUiState.Error(it.explanation)
                }
                println("repository.errorData.collect: ${it.explanation}")
            }
        }
    }

    override fun onCleared() {
        getVehiclesJob?.cancel()
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
        getVehiclesJob?.cancel()
        getVehiclesJob = coroutineScope.launch {
            uiState = TheUiState.Loading
            val resultList = repository.launchSearchRequestFor(searchQuery)
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
