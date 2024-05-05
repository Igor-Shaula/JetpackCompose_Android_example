package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content.TheAppScaffold
import com.igor_shaula.complex_api_client_sample.ui.elements.nav_drawer_content.NavDrawerPanel
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType
import com.igor_shaula.complex_api_client_sample.ui.utils.NavigationType

// top-level composable is the right place to get the viewModel as it's needed in the topBar as well
@Composable
fun TheAppScreen(
    hideKeyboard: () -> Unit = {},
    windowWidthSizeClass: WindowWidthSizeClass
) {
    val contentType: ContentType
    val navigationType: NavigationType = when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.LIST
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
        WindowWidthSizeClass.Medium -> {
            contentType = ContentType.GRID
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.GRID
            NavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            contentType = ContentType.LIST
            NavigationType.HIDDEN_NAVIGATION_DRAWER
        }
    }
    if (navigationType == NavigationType.HIDDEN_NAVIGATION_DRAWER) {
        ModalNavigationDrawer(
            drawerContent = { NavDrawerPanel() },
            drawerState = DrawerState(initialValue = DrawerValue.Closed)
        ) { TheAppScaffold(contentType, hideKeyboard) }
    } else {
        PermanentNavigationDrawer(
            drawerContent = { NavDrawerPanel() }
        ) { TheAppScaffold(contentType, hideKeyboard) }
    }
}
