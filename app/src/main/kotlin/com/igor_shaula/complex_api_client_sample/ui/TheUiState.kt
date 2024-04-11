package com.igor_shaula.complex_api_client_sample.ui

import com.igor_shaula.complex_api_client_sample.ui.models.VehicleModel

sealed interface TheUiState {

    // decided to have it instead of Loading to give some starting hints
    data object FreshStart : TheUiState

    // special UI state for the case if the request is successful but no objects are found in it
    data object EmptyList : TheUiState

    class Success(val theList: List<VehicleModel>) : TheUiState

    class Error(val errorInfo: String) : TheUiState

    data object Loading : TheUiState
}