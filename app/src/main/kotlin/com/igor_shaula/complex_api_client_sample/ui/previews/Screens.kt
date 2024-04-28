package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.igor_shaula.complex_api_client_sample.ui.elements.ExplanationScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.LoadingScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.PayloadScreen
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT

@Previews
@Composable
fun ExplanationScreenPreview() {
    ThemeWithSurface {
        ExplanationScreen(APP_BAR_HEIGHT, "explanation text")
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
