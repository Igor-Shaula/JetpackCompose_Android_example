package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel
import com.igor_shaula.complex_api_client_sample.ui.TheUiState

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
    ) { innerPadding -> // use this thing somehow - because warning emerges if it's not used
        println("innerPadding = $innerPadding")

        when (val uiState: TheUiState = viewModel.uiState) {

            TheUiState.FreshStart -> CustomizedExplanation(
                theText = stringResource(R.string.firstLaunchExplanation)
            )

            TheUiState.Loading -> CustomizedBusyIndicator()

            TheUiState.EmptyList -> CustomizedExplanation(
                theText = stringResource(R.string.emptyListExplanation)
            )

            is TheUiState.Success -> VehiclesList(uiState.theList, hideKeyboard)

            is TheUiState.Error -> CustomizedExplanation(
                theText = stringResource(id = R.string.errorStateInfo) + uiState.errorInfo
            )
        }
    }
}
