package com.igor_shaula.outdoorsy_android_challenge_task.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igor_shaula.outdoorsy_android_challenge_task.data.VehiclesRepositoryImpl
import com.igor_shaula.outdoorsy_android_challenge_task.data.local.FakeDataSource
import com.igor_shaula.outdoorsy_android_challenge_task.data.network.OneVehicleData
import com.igor_shaula.outdoorsy_android_challenge_task.domain.VehiclesRepository
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
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

    init {
        mldVehiclesList.value = FakeDataSource.fakeVehiclesList // temporary solution
    }

    override fun onCleared() {
        println("MainViewModel:onCleared")
        getVehiclesJob?.cancel()
        super.onCleared()
    }

    suspend fun updateSearchRequest(newText: String) {
        println("updateSearchRequest: newText = $newText")
        searchQuery = newText
//        getVehiclesJob = coroutineScope.launch {
        val resultList = repository.launchSearchRequestFor(newText)
        println("updateSearchRequest: resultList = $resultList")
        mldVehiclesList.value = resultList.toVehicleModels()
//        }
    }
}

private fun List<OneVehicleData>.toVehicleModels(): List<VehicleModel> {
    val result = mutableListOf<VehicleModel>()
    forEach {
        result.add(VehicleModel(vehicleImage = it.imageUrl, vehicleName = it.name))
    }
    return result
}
