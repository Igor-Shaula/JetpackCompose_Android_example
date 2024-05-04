package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING

@Composable
fun ExplanationScreen(
    paddingTop: Dp, theTitle: String, theText: String, isError: Boolean = false
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)
        .padding(
            top = paddingTop + DEFAULT_PADDING,
            start = DEFAULT_PADDING, end = DEFAULT_PADDING
        )
) {
    Text(
        text = theTitle,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(Modifier.height(DEFAULT_PADDING))
    Text(
        text = theText,
        style = if (isError) MaterialTheme.typography.bodySmall else MaterialTheme.typography.bodyMedium,
        modifier = Modifier.fillMaxWidth()
    )
}
