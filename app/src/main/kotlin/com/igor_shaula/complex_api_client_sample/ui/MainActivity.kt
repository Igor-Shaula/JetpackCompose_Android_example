package com.igor_shaula.complex_api_client_sample.ui

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
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
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedBusyIndicator
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedExplanation
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBarAlternative
import com.igor_shaula.complex_api_client_sample.ui.elements.VehiclesList
import com.igor_shaula.complex_api_client_sample.ui.models.VehicleModel
import com.igor_shaula.complex_api_client_sample.ui.theme.OutdoorsyAndroidChallengeTaskTheme

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
                                CustomizedSearchBarAlternative(viewModel.searchQueryForUI, ::handleSearchQuery)
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
                        CustomizedExplanation(theText = getString(R.string.firstLaunchExplanation))
                    } else if (vehicles.isEmpty()) {
                        CustomizedExplanation(theText = getString(R.string.emptyListExplanation))
                    } else {
                        VehiclesList(vehicles, ::hideKeyboard) // to hide keyboard on scroll events
                    }
                }
            }
        }
    }

    private fun handleSearchQuery(query: String) {
        println("onQueryChange: new query = $query")
        viewModel.updateSearchRequest(query)
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
