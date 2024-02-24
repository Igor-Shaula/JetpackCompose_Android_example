package com.igor_shaula.complex_api_client_sample.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.igor_shaula.complex_api_client_sample.data.VehiclesRepositoryImpl
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.ui.models.VehicleModel
import com.igor_shaula.complex_api_client_sample.ui.models.toVehicleModels
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class MainViewModel : ViewModel() {

    var vehiclesList by mutableStateOf(listOf<VehicleModel>())
        private set

    var searchQueryForUI by mutableStateOf("")
        private set

    var isBusyState by mutableStateOf(false)
        private set

    var errorInfo by mutableStateOf("")
        private set

    var isFreshStart by mutableStateOf(true)
        private set

    private val repository: VehiclesRepository = VehiclesRepositoryImpl()

    private val coroutineScope = MainScope() + CoroutineName(this.javaClass.simpleName)

    private var getVehiclesJob: Job? = null

    private var searchQuery = ""

    init {
        coroutineScope.launch {
            repository.errorData.collect {
                errorInfo = it.explanation.toString() // transports the error state onto UI layer
                println("repository.errorData.collect: $errorInfo")
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
            isBusyState = true
            val resultList = repository.launchSearchRequestFor(searchQuery)
            println("updateSearchRequest: resultList = $resultList")
            vehiclesList = resultList.toVehicleModels()
            isBusyState = false
        }
        isFreshStart = false
    }

    fun setFreshStart() {
        isFreshStart = true
    }
}
