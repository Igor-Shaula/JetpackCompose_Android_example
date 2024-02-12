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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedExplanation
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedSearchBar
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.VehiclesList
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.theme.OutdoorsyAndroidChallengeTaskTheme
import kotlinx.coroutines.launch

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
    fun MainScreenWithTopBarAndList(vehicles: List<VehicleModel>) {
        OutdoorsyAndroidChallengeTaskTheme {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                CustomizedSearchBar(viewModel.searchQuery, ::handleSearchQuery)
                            },
                            modifier = Modifier
                                .height(88.dp)
                                .shadow(elevation = 8.dp)
                        )
                    }
                ) { innerPadding -> // use this thing somehow - because warning emerges if it's not used
                    println("innerPadding = $innerPadding")
                    VehiclesList(vehicles, modifier = Modifier)
                }
            }
        }
    }

    private fun handleSearchQuery(query: String) {
        println("onQueryChange: new query = $query")
        lifecycleScope.launch {
            kotlin.runCatching {
                viewModel.updateSearchRequest(query)
            }.onSuccess { items ->
                // TODO show the list
                println("onSuccess: items = $items")
            }.onFailure {
                // TODO show error
                println("onFailure")
            }
        }
    }
}
