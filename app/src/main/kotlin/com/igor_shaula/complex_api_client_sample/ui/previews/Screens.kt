package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.igor_shaula.complex_api_client_sample.ui.TheUiState
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.ExplanationScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.LoadingScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.PayloadScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.TheAppBody
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType

@DayNightPreviews
@Composable
fun TheAppScreenPreview() {
    ThemeWithSurface {
        TheAppScreen(
            hideKeyboard = {},
            windowWidthSizeClass = WindowWidthSizeClass.Compact,
        )
    }
}

@DayNightPreviews
@Composable
fun TheAppBodyStartPreview() {
    ThemeWithSurface {
        TheAppBody(
            uiState = TheUiState.FreshStart,
            hideKeyboard = { },
            paddingValues = PaddingValues(top = APP_BAR_HEIGHT),
            contentType = ContentType.LIST
        )
    }
}

@DayNightPreviews
@Composable
fun ExplanationScreenPreview() {
    ThemeWithSurface {
        ExplanationScreen(
            APP_BAR_HEIGHT, theTitle = "explanation TITLE", theText = "explanation text"
        )
    }
}

@DayNightPreviews
@Composable
fun LoadingScreenPreview() {
    ThemeWithSurface {
        LoadingScreen()
    }
}

@DayNightPreviews
@Composable
fun PayloadScreenPreviewList() {
    ThemeWithSurface {
        mutableListOf<TheUiModel>().apply {
            repeat(10) {
                add(TheUiModel("", "item #$it"))
            }
        }.also {
            PayloadScreen(
                paddingTop = PaddingValues(top = APP_BAR_HEIGHT).calculateTopPadding(),
                theUiModelList = it,
                contentType = ContentType.LIST
            )
        }
    }
}

@DayNightPreviews
@OrientationPreviews
@Composable
fun PayloadScreenPreviewGrid() {
    ThemeWithSurface {
        mutableListOf<TheUiModel>().apply {
            repeat(10) {
                add(TheUiModel("", "item #$it"))
            }
        }.also {
            PayloadScreen(
                paddingTop = PaddingValues(top = APP_BAR_HEIGHT).calculateTopPadding(),
                theUiModelList = it,
                contentType = ContentType.GRID
            )
        }
    }
}
