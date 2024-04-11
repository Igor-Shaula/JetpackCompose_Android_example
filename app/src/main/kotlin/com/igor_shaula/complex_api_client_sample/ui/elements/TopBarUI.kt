package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_ELEVATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUI(searchQuery: String, onSearchQueryUpdate: (String, Boolean) -> Unit) {
    TopAppBar(
        title = {
            CustomizedSearchBarAlternative(searchQuery, onSearchQueryUpdate)
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        modifier = Modifier
            .height(APP_BAR_HEIGHT)
            .shadow(elevation = DEFAULT_ELEVATION)
    )
}
