package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING

@Composable
fun ExplanationScreen(paddingTop: Dp, theText: String) = Text(
    text = theText,
    style = MaterialTheme.typography.headlineSmall,
    modifier = Modifier
        .fillMaxSize()
        .padding(
            top = paddingTop + DEFAULT_PADDING,
            start = DEFAULT_PADDING, end = DEFAULT_PADDING
        )
)
