package com.igor_shaula.outdoorsy_android_challenge_task.ui.elements

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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.igor_shaula.outdoorsy_android_challenge_task.data.local.FakeDataSource.Companion.fakeVehiclesList
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.theme.OutdoorsyAndroidChallengeTaskTheme

@Preview(showBackground = true)
@Composable
fun TheAppUiPreview() {
    OutdoorsyAndroidChallengeTaskTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            VehiclesList(fakeVehiclesList)
        }
    }
}

@Composable
fun VehiclesList(vehicleList: List<VehicleModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth() // this does not work properly -> modifying Card item
            .padding(top = 88.dp + 16.dp, start = 16.dp, end = 16.dp)
    ) {
        items(vehicleList) { vehicle ->
            VehicleCard(vehicle)
        }
    }
}

@Composable
private fun VehicleCard(vehicle: VehicleModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = vehicle.vehicleImage,
                placeholder = rememberVectorPainter(image = Icons.Sharp.Done), // replace by proper SVG placeholder
                contentDescription = stringResource(id = com.igor_shaula.outdoorsy_android_challenge_task.R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
                    .width(128.dp)
                    .padding(all = 4.dp)
                    .shadow(shape = RoundedCornerShape(4.dp), elevation = 2.dp)
            )
            Text(
                text = vehicle.vehicleName,
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif,
                maxLines = 3,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

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
            contentDescription = "search icon"
        )
    },
    trailingIcon = {
        // later - if this query was added to favourites - set correct icon here
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "favourites icon"
        )
    },
    shape = RoundedCornerShape(8.dp),
    enabled = true,
    content = {
        println("content = $this")
    },
    modifier = Modifier.padding(top = 8.dp, end = 16.dp)
)

@Composable
private fun CustomizedSearchBarPlaceholderText() = Text(
    text = "Search",
    textAlign = TextAlign.Start,
    maxLines = 1,
    fontSize = 18.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Bold,
    fontFamily = FontFamily.Cursive,
//    style = MaterialTheme.typography.bodyLarge
)

@Composable
fun CustomizedExplanation(theText: String) = Text(
    text = theText,
    textAlign = TextAlign.Center,
    fontFamily = FontFamily.Cursive,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    fontSize = 24.sp,
    modifier = Modifier
        .fillMaxSize()
        .padding(top = 88.dp + 16.dp, start = 16.dp, end = 16.dp)
)

@Composable
fun CustomizedBusyIndicator() = Box(
    modifier = Modifier.fillMaxSize()
) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center)
    )
}
