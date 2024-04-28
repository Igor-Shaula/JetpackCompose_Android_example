package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBar
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBarAlternative
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppTopBar
import com.igor_shaula.complex_api_client_sample.ui.elements.TheUiCard
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel

@Previews
@Composable
fun TheAppTopBarPreview() {
    ThemeWithSurfaceElement {
        TheAppTopBar(
            searchQuery = stringResource(id = R.string.searchFieldHint),
        ) { _, _ -> }
    }
}

@Previews
@Composable
fun CustomizedSearchBarPreview() {
    ThemeWithSurfaceElement {
        CustomizedSearchBar(
            searchQuery = stringResource(id = R.string.searchFieldHint),
            handleSearchQuery = { _ -> })
    }
}

@Previews
@Composable
fun CustomizedSearchBarAlternativePreview() {
    ThemeWithSurfaceElement {
        CustomizedSearchBarAlternative(
            searchQuery = stringResource(id = R.string.searchFieldHint),
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
