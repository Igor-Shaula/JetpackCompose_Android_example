package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.view_models.MainUiState
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType

@Composable
fun TheAppBody(
    uiState: MainUiState,
    hideKeyboard: () -> Unit,
    paddingValues: PaddingValues,
    contentType: ContentType
) {
    when (uiState) {

        MainUiState.FreshStart -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.firstLaunchExplanationTitle),
            theText = stringResource(R.string.firstLaunchExplanationText)
        )

        MainUiState.Loading -> LoadingScreen()

        MainUiState.EmptyList -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.emptyListExplanationTitle),
            theText = stringResource(R.string.emptyListExplanationText)
        )

        is MainUiState.Success -> PayloadScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theUiModelList = uiState.theList,
            hideKeyboard = hideKeyboard,
            contentType = contentType
        )

        is MainUiState.Error -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.errorStateInfoTitle),
            theText = uiState.errorInfo,
            isError = true
        )
    }
}
