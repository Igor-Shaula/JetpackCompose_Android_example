package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType
import com.igor_shaula.complex_api_client_sample.ui.view_models.MainUiState

private fun String.wrapForExplanationScreen(stringResource: String): String =
    "($stringResource $this API)"

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
            activeApiName = uiState.activeApi.uiName
                .wrapForExplanationScreen(stringResource(id = R.string.forJoint)),
            theText = stringResource(R.string.firstLaunchExplanationText)
        )

        MainUiState.Loading -> LoadingScreen() // "is" is not needed here as we use an object

        is MainUiState.EmptyList -> ExplanationScreen(
            paddingTop = paddingValues.calculateTopPadding(),
            theTitle = stringResource(id = R.string.emptyListExplanationTitle),
            activeApiName = uiState.activeApi.uiName
                .wrapForExplanationScreen(stringResource(id = R.string.forJoint)),
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
            activeApiName = uiState.activeApi.uiName
                .wrapForExplanationScreen(stringResource(id = R.string.forJoint)),
            theText = uiState.errorInfo,
            isError = true
        )
    }
}
