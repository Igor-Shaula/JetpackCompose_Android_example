package com.igor_shaula.outdoorsy_android_challenge_task.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igor_shaula.outdoorsy_android_challenge_task.data.FakeDataSource
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel

class MainViewModel : ViewModel() {

    private val mldVehiclesList = MutableLiveData<List<VehicleModel>>()
    val vehiclesList: LiveData<List<VehicleModel>> get() = mldVehiclesList

    init {
        mldVehiclesList.value = FakeDataSource.fakeVehiclesList // temporary solution
    }

    override fun onCleared() {
        println("MainViewModel:onCleared")
        super.onCleared()
    }
}