package com.igor_shaula.outdoorsy_android_challenge_task.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.theme.OutdoorsyAndroidChallengeTaskTheme

// temporary here - later the data will be moved on its own layer
val fakeVehiclesList = listOf(
    VehicleModel("image-address-1", "name-1"),
    VehicleModel("image-address-2", "name-2"),
    VehicleModel("image-address-3", "name-3"),
    VehicleModel("image-address-4", "name-4"),
    VehicleModel("image-address-5", "name-5"),
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheAppUI(fakeVehiclesList)
}

@Composable
fun TheAppUI(vehicleList: List<VehicleModel>) {
    OutdoorsyAndroidChallengeTaskTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VehiclesList(vehicleList, modifier = Modifier)
        }
    }
}

@Composable
fun VehiclesList(vehicleList: List<VehicleModel>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth() // this does not work properly -> modifying Card item
    ) {
        items(vehicleList) { vehicle ->
            VehicleCard(vehicle, modifier)
        }
    }
}

@Composable
fun VehicleCard(vehicle: VehicleModel, modifier: Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_media_play),
                contentDescription = stringResource(id = com.igor_shaula.outdoorsy_android_challenge_task.R.string.app_name)
            )
            Text(
                text = LocalContext.current.getString(com.igor_shaula.outdoorsy_android_challenge_task.R.string.app_name) + vehicle.vehicleName,
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
