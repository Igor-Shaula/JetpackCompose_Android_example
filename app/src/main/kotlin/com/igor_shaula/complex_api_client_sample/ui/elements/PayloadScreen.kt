package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.utils.ContentType

@Composable
fun PayloadScreen(
    paddingTop: Dp,
    theUiModelList: List<TheUiModel>,
    hideKeyboard: (() -> Unit)? = null, // nullable for absence in preview invocations
    contentType: ContentType
) {
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // called when you scroll the content - happens pretty often -> optimize this somehow
                hideKeyboard?.invoke()
                return Offset.Zero
            }
        }
    }
    if (contentType == ContentType.LIST) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth() // this does not work properly -> modifying Card item
                .nestedScroll(nestedScrollConnection)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(
                    top = paddingTop + DEFAULT_PADDING,
                    start = DEFAULT_PADDING, end = DEFAULT_PADDING
                )
        ) {
            items(theUiModelList) { theUiModel ->
                TheUiCard(theUiModel)
            }
        }
    } else {
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 200.dp)) {
            items(theUiModelList) { theUiModel ->
                TheUiCard(theUiModel)
            }
        }
    }
}
