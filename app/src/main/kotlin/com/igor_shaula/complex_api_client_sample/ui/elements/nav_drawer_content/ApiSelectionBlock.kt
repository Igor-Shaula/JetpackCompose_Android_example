package com.igor_shaula.complex_api_client_sample.ui.elements.nav_drawer_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.SMALL_PADDING

@Composable
fun ApiSelectionBlock(apiNames: List<String> = listOf("Outdoorsy", "Beer")) {
    Column(
        modifier = Modifier
            .padding(top = DEFAULT_PADDING, bottom = DEFAULT_PADDING)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Text(
            text = "select the remote API",
            style = MaterialTheme.typography.headlineSmall.copy(textAlign = TextAlign.Center),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = DEFAULT_PADDING, bottom = SMALL_PADDING,
                    start = DEFAULT_PADDING, end = DEFAULT_PADDING
                )
        )
        apiNames.forEach { apiName ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = DEFAULT_PADDING, end = DEFAULT_PADDING)
            ) {
                Text(
                    text = apiName,
                    style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Start),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.weight(1f)
                )
                RadioButton(selected = true, onClick = { })
            }
        }
        Spacer(modifier = Modifier.height(SMALL_PADDING))
    }
}
