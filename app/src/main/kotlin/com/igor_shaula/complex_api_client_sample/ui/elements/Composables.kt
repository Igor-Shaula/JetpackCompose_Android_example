package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.data.local.FakeDataSource.Companion.fakeVehiclesList
import com.igor_shaula.complex_api_client_sample.ui.models.VehicleModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.BIG_FONT_SIZE
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_FONT_SIZE
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_RADIUS
import com.igor_shaula.complex_api_client_sample.ui.theme.IMAGE_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.IMAGE_WIDTH
import com.igor_shaula.complex_api_client_sample.ui.theme.SMALL_ELEVATION
import com.igor_shaula.complex_api_client_sample.ui.theme.SMALL_RADIUS
import com.igor_shaula.complex_api_client_sample.ui.theme.TINY_ELEVATION
import com.igor_shaula.complex_api_client_sample.ui.theme.TINY_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme

@Preview(showBackground = true)
@Composable
fun TheAppUiPreview() {
    TheAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            VehiclesList(fakeVehiclesList)
        }
    }
}

@Composable
fun VehiclesList(
    vehicleList: List<VehicleModel>,
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
                top = APP_BAR_HEIGHT + DEFAULT_PADDING,
                start = DEFAULT_PADDING, end = DEFAULT_PADDING
            )
            .nestedScroll(nestedScrollConnection)
    ) {
        items(vehicleList) { vehicle ->
            VehicleCard(vehicle)
        }
    }
}

@Composable
private fun VehicleCard(vehicle: VehicleModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = SMALL_ELEVATION),
        shape = RoundedCornerShape(size = DEFAULT_RADIUS),
        modifier = Modifier.padding(bottom = DEFAULT_PADDING) // 2dp - for top shadow, white on white!
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = vehicle.vehicleImage,
                placeholder = rememberVectorPainter(image = Icons.Rounded.Done), // replace by proper SVG placeholder
                contentDescription = stringResource(id = R.string.vehicleImageDescription),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(IMAGE_HEIGHT)
                    .width(IMAGE_WIDTH)
                    .padding(all = TINY_PADDING)
                    .shadow(shape = RoundedCornerShape(SMALL_RADIUS), elevation = TINY_ELEVATION)
            )
            Text(
                text = vehicle.vehicleName,
                color = Color.DarkGray,
                fontSize = DEFAULT_FONT_SIZE,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif,
                maxLines = 3,
                modifier = Modifier.padding(start = DEFAULT_PADDING, end = DEFAULT_PADDING)
            )
        }
    }
}

@Composable
fun CustomizedExplanation(theText: String) = Text(
    text = theText,
    textAlign = TextAlign.Center,
    fontFamily = FontFamily.Cursive,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    fontSize = BIG_FONT_SIZE,
    modifier = Modifier
        .fillMaxSize()
        .padding(
            top = APP_BAR_HEIGHT + DEFAULT_PADDING,
            start = DEFAULT_PADDING, end = DEFAULT_PADDING
        )
)

@Composable
fun CustomizedBusyIndicator() = Box(
    modifier = Modifier.fillMaxSize()
) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center)
    )
}
