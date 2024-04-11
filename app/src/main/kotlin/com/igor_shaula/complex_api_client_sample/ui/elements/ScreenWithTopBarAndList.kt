package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel
import com.igor_shaula.complex_api_client_sample.ui.theme.APP_BAR_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_ELEVATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWithTopBarAndList(hideKeyboard: () -> Unit) {

    val viewModel: MainViewModel = viewModel()
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
            CustomizedExplanation(theText = stringResource(R.string.firstLaunchExplanation))
        } else if (viewModel.errorInfo.isNotBlank()) {
            CustomizedExplanation(
                theText = stringResource(id = R.string.errorStateInfo) + viewModel.errorInfo
            )
        } else if (viewModel.vehiclesList.isEmpty()) {
            CustomizedExplanation(theText = stringResource(R.string.emptyListExplanation))
        } else {
            VehiclesList(viewModel.vehiclesList, hideKeyboard)
        }
    }
}
