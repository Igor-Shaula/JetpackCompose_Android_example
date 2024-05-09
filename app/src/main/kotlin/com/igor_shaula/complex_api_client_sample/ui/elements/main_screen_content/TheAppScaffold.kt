package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType
import com.igor_shaula.complex_api_client_sample.ui.view_models.MainViewModel

@Composable
fun TheAppScaffold(
    contentType: ContentType,
    hideKeyboard: () -> Unit = {},
    drawerState: DrawerState,
    viewModel: MainViewModel = viewModel() // it's here for enabling a preview of this composable
) {
    viewModel.onDrawerStateChange(drawerState)
    Scaffold(
        topBar = {
            TheAppTopBar(viewModel.searchQueryForUI) { query, isForced ->
                viewModel.updateSearchRequest(query, isForced)
            }
        }
    ) { paddingValues ->
        TheAppBody(viewModel.uiState, hideKeyboard, paddingValues, contentType)
    }
}