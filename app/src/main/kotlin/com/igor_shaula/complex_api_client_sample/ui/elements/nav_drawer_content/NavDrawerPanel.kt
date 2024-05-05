package com.igor_shaula.complex_api_client_sample.ui.elements.nav_drawer_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.NAV_DRAWER_WIDTH

@Composable
fun NavDrawerPanel() {

    val apiName = remember { mutableStateOf("Outdoorsy") }

    Column(
        modifier = Modifier
            .widthIn(min = 0.dp, max = NAV_DRAWER_WIDTH)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(DEFAULT_PADDING)
    ) {
        Text(
            text = stringResource(id = R.string.nav_drawer_panel_header),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.W900,
            color = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(DEFAULT_PADDING)
        )
        ApiSelectionBlock(
            selectedApi = apiName.value, setSelected = { apiName.value = it }
        )
    }
}
