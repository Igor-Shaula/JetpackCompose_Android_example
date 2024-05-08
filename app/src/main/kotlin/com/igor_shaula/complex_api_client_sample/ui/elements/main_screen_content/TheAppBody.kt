package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType
import com.igor_shaula.complex_api_client_sample.ui.view_models.MainUiState

@Composable
fun TheAppBody(
    uiState: MainUiState,
    hideKeyboard: () -> Unit,
    paddingValues: PaddingValues,
    contentType: ContentType
) {
    when (uiState) {

        is MainUiState.FreshStart -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.firstLaunchExplanationTitle),
            activeApiName =
            "(" + stringResource(id = R.string.forJoint) + uiState.activeApi.uiName + " API)",
            theText = stringResource(R.string.firstLaunchExplanationText)
        )

        MainUiState.Loading -> LoadingScreen()

        is MainUiState.EmptyList -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.emptyListExplanationTitle),
            activeApiName =
            "(" + stringResource(id = R.string.forJoint) + uiState.activeApi.uiName + " API)",
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
            activeApiName =
            "(" + stringResource(id = R.string.forJoint) + uiState.activeApi.uiName + " API)",
            theText = uiState.errorInfo,
            isError = true
        )
    }
}
