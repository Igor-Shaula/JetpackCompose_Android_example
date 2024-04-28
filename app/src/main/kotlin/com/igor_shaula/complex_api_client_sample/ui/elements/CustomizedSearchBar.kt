package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_FONT_SIZE
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
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start,
    modifier = Modifier
        .padding(end = DEFAULT_PADDING)
        .background(color = Color.White)
        .fillMaxWidth()
) {
    Icon(
        imageVector = Icons.Rounded.Search,
        contentDescription = stringResource(id = R.string.leadingSearchIconDescription),
        modifier = Modifier
            .padding(start = DEFAULT_PADDING + TINY_PADDING)
            .fillMaxHeight()
    )
    TextField(
        placeholder = { CustomizedSearchBarPlaceholderText() },
        shape = RoundedCornerShape(DEFAULT_RADIUS),
        singleLine = true,
        value = searchQuery,
        onValueChange = { handleSearchQuery(it, false) }, // optimization logic will handle spaces
        keyboardActions = KeyboardActions(
            onSearch = { handleSearchQuery(searchQuery, true) }), // -> forcibly updateSearchRequest
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Red // we are not supposed to see the error state, but let it stay here to be visible
        ),
        modifier = Modifier
            .fillMaxWidth()
//                .paddingFromBaseline(top = 0.dp, bottom = 0.dp)
    )
}

@Composable
private fun CustomizedSearchBarPlaceholderText() = Text(
    text = stringResource(id = R.string.searchFieldHint),
    textAlign = TextAlign.Start,
    maxLines = 1,
    fontSize = DEFAULT_FONT_SIZE,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Black,
    fontFamily = FontFamily.SansSerif,
    color = Color.DarkGray
)
