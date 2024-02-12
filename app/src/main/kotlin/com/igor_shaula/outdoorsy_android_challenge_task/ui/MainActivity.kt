package com.igor_shaula.outdoorsy_android_challenge_task.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedBusyIndicator
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedExplanation
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedSearchBar
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.VehiclesList
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.theme.OutdoorsyAndroidChallengeTaskTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        setContent {
            MainScreenWithTopBarAndList()
        }
        viewModel.vehiclesList.observe(this) { vehicles ->
            setContent {
                MainScreenWithTopBarAndList(vehicles)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreenWithTopBarAndList(vehicles: List<VehicleModel>? = null) {
        OutdoorsyAndroidChallengeTaskTheme {
            val isSearching by viewModel.isBusyStateFlow.collectAsState()
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                CustomizedSearchBar(viewModel.searchQueryForUI, ::handleSearchQuery)
                            },
                            modifier = Modifier
                                .height(88.dp)
                                .shadow(elevation = 8.dp)
                        )
                    }
                ) { innerPadding -> // use this thing somehow - because warning emerges if it's not used
                    println("innerPadding = $innerPadding")
//                    if (viewModel.isBusyState) { // this approach also works, no new variables required
                    if (isSearching) { // decided to not to use "when" statement as it takes more space
                        CustomizedBusyIndicator()
                    } else if (vehicles == null) {
                        CustomizedExplanation(theText = "Please use the Search box to obtain a list of Recreational Vehicles you are interested in.")
                    } else if (vehicles.isEmpty()) {
                        CustomizedExplanation(theText = "Nothing found for the given query.\nPlease try something different.")
                    } else {
                        VehiclesList(vehicles, modifier = Modifier)
                    }
                }
            }
        }
    }

    private fun handleSearchQuery(query: String) {
        println("onQueryChange: new query = $query")
        viewModel.updateSearchRequest(query)
    }
}
