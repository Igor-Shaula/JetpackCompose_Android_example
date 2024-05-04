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
            theTitle = stringResource(id = R.string.firstLaunchExplanationTitle),
            theText = stringResource(R.string.firstLaunchExplanationText)
        )

        TheUiState.Loading -> LoadingScreen()

        TheUiState.EmptyList -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.emptyListExplanationTitle),
            theText = stringResource(R.string.emptyListExplanationText)
        )

        is TheUiState.Success -> PayloadScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theUiModelList = uiState.theList,
            hideKeyboard = hideKeyboard
        )

        is TheUiState.Error -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.errorStateInfoTitle),
            theText = uiState.errorInfo
        )
    }
}
