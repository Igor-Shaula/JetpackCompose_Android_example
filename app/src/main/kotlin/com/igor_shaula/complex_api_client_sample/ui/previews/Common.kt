package com.igor_shaula.complex_api_client_sample.ui.previews

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 255L,
    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0L,
    showBackground = true
)
annotation class Previews // to have both color schemes in one annotation

@Composable
fun ThemeWithSurface(content: @Composable () -> Unit) {
    TheAppTheme {
        Surface(tonalElevation = 4.dp) {
            content()
        }
    }
}

@Composable
fun ThemeWithSurfaceElement(content: @Composable () -> Unit) {
    TheAppTheme {
        Surface(
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth() // the only difference - needed only for previews
        ) {
            content()
        }
    }
}
