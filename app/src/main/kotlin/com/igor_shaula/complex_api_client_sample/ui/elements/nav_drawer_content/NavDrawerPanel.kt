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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.NAV_DRAWER_WIDTH
import com.igor_shaula.complex_api_client_sample.ui.view_models.DrawerViewModel

@Composable
fun NavDrawerPanel() {
    val viewModel: DrawerViewModel = viewModel()
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
            selectedApi = viewModel.uiState.activeApi.uiName,
            setSelected = { newApi ->
                viewModel.onActiveApiChange(newApi)
            }
        )
    }
}
