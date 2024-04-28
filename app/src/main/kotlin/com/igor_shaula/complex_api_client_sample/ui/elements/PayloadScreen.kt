package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING

@Composable
fun PayloadScreen(
    paddingTop: Dp,
    theUiModelList: List<TheUiModel>,
    hideKeyboard: (() -> Unit)? = null // nullable for absence in preview invocations
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
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth() // this does not work properly -> modifying Card item
            .padding(
                top = paddingTop + DEFAULT_PADDING,
                start = DEFAULT_PADDING, end = DEFAULT_PADDING
            )
            .nestedScroll(nestedScrollConnection)
    ) {
        items(theUiModelList) { theUiModel ->
            TheUiCard(theUiModel)
        }
    }
}
