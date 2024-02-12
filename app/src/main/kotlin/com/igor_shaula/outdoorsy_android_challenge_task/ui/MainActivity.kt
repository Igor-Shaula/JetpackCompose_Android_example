package com.igor_shaula.outdoorsy_android_challenge_task.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.CustomizedSearchBarPlaceholderText
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.VehiclesList
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel
import com.igor_shaula.outdoorsy_android_challenge_task.ui.theme.OutdoorsyAndroidChallengeTaskTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(ProgressBar(this))
//    }

    override fun onStart() {
        super.onStart()
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
                            modifier = Modifier
                                .height(88.dp)
                                .shadow(elevation = 8.dp),
                            title = {
                                CustomizedSearchBar()
                            }
                        )
                    }
                ) { innerPadding ->
                    println("innerPadding = $innerPadding")
                    VehiclesList(vehicles, modifier = Modifier)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun CustomizedSearchBar() = SearchBar(
        query = viewModel.searchQuery,
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
