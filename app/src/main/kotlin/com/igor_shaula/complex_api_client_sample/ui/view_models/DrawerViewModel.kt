package com.igor_shaula.complex_api_client_sample.ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrawerViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    var uiState: DrawerUiState by mutableStateOf(DrawerUiState(ActiveApi.default()))
        private set

    init {
        setupForChangingActiveApi()
    }

    fun onActiveApiChange(newApi: String) {
        settingsRepository.setActiveApi(ActiveApi.fromName(newApi))
//        uiState = DrawerUiState(settingsRepository.getChosenApi()) // -> setupForChangingActiveApi()

        // the following is just a part of an experiment
        viewModelScope.launch {
            settingsRepository.activeApiChannel.send(ActiveApi.fromName(newApi))
        }
        println("onActiveApiChange: all worked for newApi: $newApi")
    }

    private fun setupForChangingActiveApi() {
        viewModelScope.launch {
            settingsRepository.activeApiStateFlow.collect { activeApi ->
                uiState = DrawerUiState(activeApi)
            }
        }
    }
}
