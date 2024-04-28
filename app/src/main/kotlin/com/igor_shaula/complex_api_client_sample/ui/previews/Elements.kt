package com.igor_shaula.complex_api_client_sample.ui.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBar
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBarAlternative
import com.igor_shaula.complex_api_client_sample.ui.elements.TheUiCard
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme

@Preview(showBackground = true)
@Composable
fun CustomizedSearchBarPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomizedSearchBar(
                searchQuery = "search this",
                handleSearchQuery = { _ -> })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomizedSearchBarAlternativePreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomizedSearchBarAlternative(
                searchQuery = "search this",
                handleSearchQuery = { _, _ -> })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TheUiCardPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            TheUiCard(theUiModel = TheUiModel("image", "name"))
        }
    }
}
