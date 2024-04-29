package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel

// top-level composable is the right place to get the viewModel as it's needed in the topBar as well
@Composable
fun TheAppScreen(
    hideKeyboard: () -> Unit = {},
    viewModel: MainViewModel = viewModel() // it's here for enabling a preview of this composable
) {
    Scaffold(
        topBar = {
            TheAppTopBar(viewModel.searchQueryForUI) { query, isForced ->
                viewModel.updateSearchRequest(query, isForced)
            }
        }
    ) { paddingValues ->
        TheAppBody(viewModel.uiState, hideKeyboard, paddingValues)
    }
}
