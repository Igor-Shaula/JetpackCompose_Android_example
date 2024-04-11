package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.TheUiState

@Composable
fun TheAppBody(
    uiState: TheUiState, hideKeyboard: () -> Unit, paddingValues: PaddingValues
) {
    println("paddingValues = $paddingValues") // later decide where to use it appropriately

    when (uiState) {

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
