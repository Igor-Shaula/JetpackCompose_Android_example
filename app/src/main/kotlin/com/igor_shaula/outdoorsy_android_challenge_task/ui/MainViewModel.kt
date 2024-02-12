package com.igor_shaula.outdoorsy_android_challenge_task.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igor_shaula.outdoorsy_android_challenge_task.data.VehiclesRepositoryImpl
import com.igor_shaula.outdoorsy_android_challenge_task.domain.VehiclesRepository
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.toVehicleModels
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class MainViewModel : ViewModel() {

    // LiveData is shown in the description of androidx.lifecycle.ViewModel
    private val mldVehiclesList = MutableLiveData<List<VehicleModel>>() // classic approach
    val vehiclesList: LiveData<List<VehicleModel>> get() = mldVehiclesList

    private var searchQuery = ""
    var searchQueryForUI by mutableStateOf("")
        private set

    var isBusyState by mutableStateOf(false) // this approach seems easier and will also work
        private set
    private val _isBusyStateFlow = MutableStateFlow(false) // using this for diversity :)
    val isBusyStateFlow = _isBusyStateFlow.asStateFlow()

    private val coroutineScope = MainScope() + CoroutineName(this.javaClass.simpleName)

    private var getVehiclesJob: Job? = null

    private val repository: VehiclesRepository = VehiclesRepositoryImpl()

    override fun onCleared() {
        getVehiclesJob?.cancel()
        super.onCleared()
    }

    fun updateSearchRequest(newText: String) {
        println("updateSearchRequest: newText = $newText")

        // before any logic is started - users have to see what they are typing at the moment
        searchQueryForUI =
            newText // to show on UI what the user is actually typed in the Search field

        // at first it would be wise to check if the user typed spaces - in fact that would be the same query
        if (newText.trim() == searchQuery) {
            return // just let the previous possibly running query to finish its work
        }
        // if the query is really different - we have to stop possible previous request
        getVehiclesJob?.cancel()
        getVehiclesJob = null // because in JVM we trust :) good old ways...

        // now we can update the real query data and launch the real network job
        searchQuery = newText.trim()
        getVehiclesJob = coroutineScope.launch {
            _isBusyStateFlow.update { true }
//            isBusyState = true
            val resultList = repository.launchSearchRequestFor(searchQuery)
            println("updateSearchRequest: resultList = $resultList")
            mldVehiclesList.value = resultList.toVehicleModels()
            _isBusyStateFlow.update { false }
//            isBusyState = false
        }
    }
}
