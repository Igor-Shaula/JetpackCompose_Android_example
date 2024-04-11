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

        TheUiState.FreshStart -> ExplanationScreen(
            theText = stringResource(R.string.firstLaunchExplanation)
        )

        TheUiState.Loading -> LoadingScreen()

        TheUiState.EmptyList -> ExplanationScreen(
            theText = stringResource(R.string.emptyListExplanation)
        )

        is TheUiState.Success -> PayloadScreen(uiState.theList, hideKeyboard)

        is TheUiState.Error -> ExplanationScreen(
            theText = stringResource(id = R.string.errorStateInfo) + uiState.errorInfo
        )
    }
}
