package com.igor_shaula.complex_api_client_sample.ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawerViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    var uiState: DrawerUiState by mutableStateOf(DrawerUiState(ActiveApi.OUTDOORSY))
        private set

    fun onActiveApiChange(newApi: String) {
        settingsRepository.setChosenApi(ActiveApi.fromName(newApi))
        uiState = DrawerUiState(settingsRepository.getChosenApi())
    }
}
