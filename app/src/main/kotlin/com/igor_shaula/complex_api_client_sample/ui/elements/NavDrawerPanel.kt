package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.NAV_DRAWER_WIDTH

@Composable
fun NavDrawerPanel(topPaddingDp: Dp = 0.dp) {
    Column(
        modifier = Modifier
            .widthIn(min = 0.dp, max = NAV_DRAWER_WIDTH)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(
                top = topPaddingDp + DEFAULT_PADDING,
                start = DEFAULT_PADDING, end = DEFAULT_PADDING, bottom = DEFAULT_PADDING
            )
    ) {
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.onTertiary)
//        ApiSelectionBlock()
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.onTertiary)
    }
}
