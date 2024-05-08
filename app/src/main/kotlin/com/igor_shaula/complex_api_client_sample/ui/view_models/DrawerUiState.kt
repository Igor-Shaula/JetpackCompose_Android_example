package com.igor_shaula.complex_api_client_sample.ui.view_models

import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi

// sealed interface is not needed here as the Drawer has only one UI state with different values
data class DrawerUiState(val activeApi: ActiveApi)