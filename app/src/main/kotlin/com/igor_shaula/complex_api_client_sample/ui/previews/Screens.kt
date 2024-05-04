package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.PaddingValues
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

@Previews
@Composable
fun TheAppScreenPreview(
//    viewModel: MainViewModel = viewModel() // doesn't help
) {
    ThemeWithSurface {
//        TheAppScreen(hideKeyboard = {}, viewModel = viewModel()) // doesn't help
        val viewModel: MainViewModel = viewModel()
        TheAppScreen(hideKeyboard = {}, viewModel = viewModel) // also doesn't help
    }
}

@Previews
@Composable
fun TheAppBodyPreview() {
    ThemeWithSurface {
        TheAppBody(
            uiState = TheUiState.FreshStart,
            hideKeyboard = { },
            paddingValues = PaddingValues(top = APP_BAR_HEIGHT)
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
fun PayloadScreenPreview() {
    ThemeWithSurface {
        mutableListOf<TheUiModel>().apply {
            repeat(10) {
                add(TheUiModel("", "item #$it"))
            }
        }.also {
            PayloadScreen(
                paddingTop = PaddingValues(top = APP_BAR_HEIGHT).calculateTopPadding(),
                theUiModelList = it
            )
        }
    }
}
