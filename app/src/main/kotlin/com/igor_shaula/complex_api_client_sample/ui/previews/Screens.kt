package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel
import com.igor_shaula.complex_api_client_sample.ui.TheUiState
import com.igor_shaula.complex_api_client_sample.ui.elements.ExplanationScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.LoadingScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.PayloadScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppBody
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppScreen
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType

@Previews
@Composable
fun TheAppScreenPreview(
//    viewModel: MainViewModel = viewModel() // doesn't help for rendering the previews
) {
    ThemeWithSurface {
//        TheAppScreen(hideKeyboard = {}, viewModel = viewModel()) // doesn't help as well
        val viewModel: MainViewModel = viewModel()
        TheAppScreen(
            hideKeyboard = {},
            windowWidthSizeClass = WindowWidthSizeClass.Compact,
            viewModel = viewModel // also doesn't help
        )
    }
}

@Previews
@Composable
fun TheAppBodyPreviewList() {
    ThemeWithSurface {
        TheAppBody(
            uiState = TheUiState.FreshStart,
            hideKeyboard = { },
            paddingValues = PaddingValues(top = APP_BAR_HEIGHT),
            contentType = ContentType.LIST
        )
    }
}

@Previews
@Composable
fun TheAppBodyPreviewGrid() {
    ThemeWithSurface {
        TheAppBody(
            uiState = TheUiState.FreshStart,
            hideKeyboard = { },
            paddingValues = PaddingValues(top = APP_BAR_HEIGHT),
            contentType = ContentType.GRID
        )
    }
}

@Previews
@Composable
fun ExplanationScreenPreview() {
    ThemeWithSurface {
        ExplanationScreen(
            APP_BAR_HEIGHT, theTitle = "explanation TITLE", theText = "explanation text"
        )
    }
}

@Previews
@Composable
fun LoadingScreenPreview() {
    ThemeWithSurface {
        LoadingScreen()
    }
}

@Previews
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

@Previews
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
