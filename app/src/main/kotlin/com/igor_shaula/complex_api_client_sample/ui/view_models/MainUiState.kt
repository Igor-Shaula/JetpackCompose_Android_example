package com.igor_shaula.complex_api_client_sample.ui.view_models

import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel

sealed interface MainUiState {

    // decided to have it instead of Loading to give some starting hints
    data object FreshStart : MainUiState

    // special UI state for the case if the request is successful but no objects are found in it
    data object EmptyList : MainUiState

    class Success(val theList: List<TheUiModel>) : MainUiState

    class Error(val errorInfo: String) : MainUiState

    data object Loading : MainUiState
}
