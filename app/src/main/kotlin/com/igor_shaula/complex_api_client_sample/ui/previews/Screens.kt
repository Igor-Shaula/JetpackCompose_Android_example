package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.igor_shaula.complex_api_client_sample.ui.elements.ExplanationScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.LoadingScreen
import com.igor_shaula.complex_api_client_sample.ui.elements.PayloadScreen
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme

@Preview(showBackground = true)
@Composable
fun ExplanationScreenPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            ExplanationScreen(APP_BAR_HEIGHT, "explanation text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            LoadingScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PayloadScreenPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
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
}
