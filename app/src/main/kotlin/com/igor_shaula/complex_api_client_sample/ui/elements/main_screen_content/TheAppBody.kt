package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.TheUiState
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.ExplanationScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.LoadingScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.PayloadScreen
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType

@Composable
fun TheAppBody(
    uiState: TheUiState,
    hideKeyboard: () -> Unit,
    paddingValues: PaddingValues,
    contentType: ContentType
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
            hideKeyboard = hideKeyboard,
            contentType = contentType
        )

        is TheUiState.Error -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.errorStateInfoTitle),
            theText = uiState.errorInfo,
            isError = true
        )
    }
}
