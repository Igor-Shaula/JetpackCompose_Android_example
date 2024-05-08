package com.igor_shaula.complex_api_client_sample.ui.view_models

import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel

sealed interface MainUiState {

    // decided to have it instead of Loading to give some starting hints
    data class FreshStart(val activeApi: ActiveApi) : MainUiState

    // special UI state for the case if the request is successful but no objects are found in it
    data class EmptyList(val activeApi: ActiveApi) : MainUiState

    data class Success(val theList: List<TheUiModel>) : MainUiState

    data class Error(val errorInfo: String, val activeApi: ActiveApi) : MainUiState

    data object Loading : MainUiState
}
