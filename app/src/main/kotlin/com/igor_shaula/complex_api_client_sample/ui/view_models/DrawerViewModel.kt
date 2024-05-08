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

    var uiState: DrawerUiState by mutableStateOf(DrawerUiState(ActiveApi.OUTDOORSY))
        private set

    init {
        setupForChangingActiveApi()
    }

    fun onActiveApiChange(newApi: String) {
        settingsRepository.setActiveApi(ActiveApi.fromName(newApi))
//        uiState = DrawerUiState(settingsRepository.getChosenApi()) // -> setupForChangingActiveApi()
    }

    private fun setupForChangingActiveApi() {
        viewModelScope.launch {
            settingsRepository.activeApiFlow.collect { activeApi ->
                uiState = DrawerUiState(activeApi)
            }
        }
    }
}
