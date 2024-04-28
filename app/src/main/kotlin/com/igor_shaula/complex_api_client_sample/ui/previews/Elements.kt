package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.runtime.Composable
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBar
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBarAlternative
import com.igor_shaula.complex_api_client_sample.ui.elements.TheUiCard
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel

@Previews
@Composable
fun CustomizedSearchBarPreview() {
    ThemeWithSurfaceElement {
        CustomizedSearchBar(
            searchQuery = "search this",
            handleSearchQuery = { _ -> })
    }
}

@Previews
@Composable
fun CustomizedSearchBarAlternativePreview() {
    ThemeWithSurfaceElement {
        CustomizedSearchBarAlternative(
            searchQuery = "search this",
            handleSearchQuery = { _, _ -> })
    }
}

@Previews
@Composable
fun TheUiCardPreview() {
    ThemeWithSurfaceElement {
        TheUiCard(theUiModel = TheUiModel("image", "name"))
    }
}
