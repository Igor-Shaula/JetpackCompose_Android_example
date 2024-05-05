package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType
import com.igor_shaula.complex_api_client_sample.ui.utils.NavigationType

// top-level composable is the right place to get the viewModel as it's needed in the topBar as well
@Composable
fun TheAppScreen(
    hideKeyboard: () -> Unit = {},
    windowWidthSizeClass: WindowWidthSizeClass,
    viewModel: MainViewModel = viewModel() // it's here for enabling a preview of this composable
) {
    val contentType: ContentType
    val navigationType: NavigationType = when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.LIST
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
        WindowWidthSizeClass.Medium -> {
            contentType = ContentType.GRID
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.GRID
            NavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            contentType = ContentType.LIST
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
    }
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
