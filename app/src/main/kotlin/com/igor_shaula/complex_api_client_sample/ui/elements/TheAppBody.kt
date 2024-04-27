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
    when (uiState) {

        TheUiState.FreshStart -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theText = stringResource(R.string.firstLaunchExplanation)
        )

        TheUiState.Loading -> LoadingScreen()

        TheUiState.EmptyList -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theText = stringResource(R.string.emptyListExplanation)
        )

        is TheUiState.Success -> PayloadScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theUiModelList = uiState.theList,
            hideKeyboard = hideKeyboard
        )

        is TheUiState.Error -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theText = stringResource(id = R.string.errorStateInfo) + uiState.errorInfo
        )
    }
}
