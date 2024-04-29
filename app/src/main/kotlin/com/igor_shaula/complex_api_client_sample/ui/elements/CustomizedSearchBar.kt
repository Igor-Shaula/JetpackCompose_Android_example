package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_RADIUS
import com.igor_shaula.complex_api_client_sample.ui.theme.SMALL_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.TINY_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizedSearchBar(
    searchQuery: String, handleSearchQuery: (String) -> Unit
) = SearchBar(
    query = searchQuery,
    onQueryChange = { newQuery ->
        handleSearchQuery(newQuery)
    },
    onSearch = {
        println("onSearch: it = $it")
    },
    active = false,
    onActiveChange = {
        println("onActiveChange: it = $it")
    },
    placeholder = {
        CustomizedSearchBarPlaceholderText()
    },
    leadingIcon = {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.leadingSearchIconDescription)
        )
    },
    trailingIcon = {
        // later - if this query was added to favourites - set correct icon here
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = stringResource(id = R.string.trailingSearchIconDescription)
        )
    },
    shape = RoundedCornerShape(DEFAULT_RADIUS),
    enabled = true,
    content = {
        println("content = $this")
    },
    modifier = Modifier.padding(top = SMALL_PADDING, end = DEFAULT_PADDING)
)

@Composable
fun CustomizedSearchBarAlternative(
    searchQuery: String, handleSearchQuery: (String, Boolean) -> Unit
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = DEFAULT_PADDING, end = DEFAULT_PADDING, bottom = DEFAULT_PADDING)
        .background(
            color = MaterialTheme.colorScheme.background,
            shape = MaterialTheme.shapes.extraSmall
        )
) {
    TextField(
        placeholder = { CustomizedSearchBarPlaceholderText() },
        singleLine = true,
        value = searchQuery,
        onValueChange = {
            handleSearchQuery(it, false) // optimization logic will handle spaces and other blanks
        },
        keyboardActions = KeyboardActions(
            onSearch = {
                handleSearchQuery(searchQuery, true) // -> forcibly updateSearchRequest
            }),
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            errorIndicatorColor = Color.Red // we are not supposed to see the error state, but let it stay here to be visible
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = stringResource(id = R.string.leadingSearchIconDescription),
//                modifier = Modifier.padding(start = TINY_PADDING) // outer padding is better here
            )
        },
//        trailingIcon = {
//            Icon(
//                imageVector = Icons.Rounded.FavoriteBorder,
//                contentDescription = stringResource(id = R.string.trailingSearchIconDescription)
//            )
//        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = TINY_PADDING) // to perfectly position the leadingIcon
    )
}

@Composable
private fun CustomizedSearchBarPlaceholderText() = Text(
    text = stringResource(id = R.string.searchFieldHint),
//    maxLines = 1, // this in fact doesn't influence on Search field
    style = MaterialTheme.typography.bodyLarge,
)
