package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel

@Composable
fun TheAppScreen(hideKeyboard: () -> Unit) {

    // top-level composable is the right place of referencing the viewModel as it's needed in topBar as well
    val viewModel: MainViewModel = viewModel()

    Scaffold(
        topBar = {
            TopBarUI(viewModel.searchQueryForUI) { query, isForced ->
                viewModel.updateSearchRequest(query, isForced)
            }
        }
    ) { // use this thing somehow - because warning emerges if it's not used
        BodyUI(viewModel.uiState, hideKeyboard, it)
    }
}
