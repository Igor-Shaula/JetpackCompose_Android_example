package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_ELEVATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheAppTopBar(
    searchQuery: String, onSearchQueryUpdate: (String, Boolean) -> Unit
) = TopAppBar(
    title = {
        CustomizedSearchBarAlternative(searchQuery, onSearchQueryUpdate)
    },
    scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    colors = TopAppBarColors(
        containerColor = MaterialTheme.colorScheme.tertiary,
        scrolledContainerColor = MaterialTheme.colorScheme.tertiary,
        navigationIconContentColor = MaterialTheme.colorScheme.onTertiary,
        titleContentColor = MaterialTheme.colorScheme.onTertiary,
        actionIconContentColor = MaterialTheme.colorScheme.onTertiary
    ),
    modifier = Modifier
        .height(APP_BAR_HEIGHT)
        .shadow(elevation = DEFAULT_ELEVATION)
)
