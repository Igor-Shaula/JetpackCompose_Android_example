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
import kotlinx.coroutines.plus

class MainViewModel : ViewModel() {

    private val mldVehiclesList = MutableLiveData<List<VehicleModel>>()
    val vehiclesList: LiveData<List<VehicleModel>> get() = mldVehiclesList

    var searchQuery by mutableStateOf("")
        private set

    private val coroutineScope = MainScope() + CoroutineName(this.javaClass.simpleName)

    private var getVehiclesJob: Job? = null

    private val repository: VehiclesRepository = VehiclesRepositoryImpl()

    override fun onCleared() {
        println("MainViewModel:onCleared")
        getVehiclesJob?.cancel()
        super.onCleared()
    }

    suspend fun updateSearchRequest(newText: String) {
        println("updateSearchRequest: newText = $newText")
        searchQuery = newText
//        getVehiclesJob = coroutineScope.launch {
        val resultList = repository.launchSearchRequestFor(newText.trim())
        println("updateSearchRequest: resultList = $resultList")
        mldVehiclesList.value = resultList.toVehicleModels()
//        }
    }
}
