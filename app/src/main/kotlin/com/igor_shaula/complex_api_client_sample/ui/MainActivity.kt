package com.igor_shaula.complex_api_client_sample.ui

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedBusyIndicator
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedExplanation
import com.igor_shaula.complex_api_client_sample.ui.elements.CustomizedSearchBarAlternative
import com.igor_shaula.complex_api_client_sample.ui.elements.VehiclesList
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_ELEVATION
import com.igor_shaula.complex_api_client_sample.ui.theme.TheAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // just to see what happens when this callback is invoked
        println("savedInstanceState = $savedInstanceState")
        println("persistentState = $persistentState")
        // if setContent is invoked in this onCreate - the screen stays blank white and nothing more happens
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // todo: decide if this is needed here
        setContent {
            RootAppContent()
        }
    }

    @Composable
    fun RootAppContent() {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            TheAppTheme {
                ScreenWithTopBarAndList()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ScreenWithTopBarAndList() {

        val viewModel: MainViewModel by viewModels()
        viewModel.setFreshStart()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        CustomizedSearchBarAlternative(
                            viewModel.searchQueryForUI
                        ) { query, isForced -> viewModel.updateSearchRequest(query, isForced) }
                    },
                    modifier = Modifier
                        .height(APP_BAR_HEIGHT)
                        .shadow(elevation = DEFAULT_ELEVATION)
                )
            }
        ) { innerPadding -> // use this thing somehow - because warning emerges if it's not used
            println("innerPadding = $innerPadding")
            // decided to not to use "when" statement as it takes more space
            if (viewModel.isBusyState) {
                CustomizedBusyIndicator()
            } else if (viewModel.isFreshStart) {
                CustomizedExplanation(theText = getString(R.string.firstLaunchExplanation))
            } else if (viewModel.errorInfo.isNotBlank()) {
                CustomizedExplanation(
                    theText = stringResource(id = R.string.errorStateInfo) + viewModel.errorInfo
                )
            } else if (viewModel.vehiclesList.isEmpty()) {
                CustomizedExplanation(theText = getString(R.string.emptyListExplanation))
            } else {
                VehiclesList(viewModel.vehiclesList, ::hideKeyboard)
            }
        }
    }

    // to hide keyboard on scroll events
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
