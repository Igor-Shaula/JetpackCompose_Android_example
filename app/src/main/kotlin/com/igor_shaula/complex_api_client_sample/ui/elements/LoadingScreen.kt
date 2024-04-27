package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme

@Composable
fun LoadingScreen() = Box(
    modifier = Modifier.fillMaxSize()
) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center)
    )
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
