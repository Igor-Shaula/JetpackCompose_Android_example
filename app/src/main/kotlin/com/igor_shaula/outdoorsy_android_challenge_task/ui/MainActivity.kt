package com.igor_shaula.outdoorsy_android_challenge_task.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
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
        // TODO:
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
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = android.R.drawable.ic_menu_search),
                                        contentDescription = "search icon",
                                        alignment = Alignment.Center
                                    )
                                    TextField(
                                        value = viewModel.searchQuery,
                                        onValueChange = { newText ->
                                            println("onValueChange: new value = $newText")
                                            // TODO: remove all spaces and blank symbols
                                            lifecycleScope.launch {
                                                kotlin.runCatching {
                                                    viewModel.updateSearchRequest(newText)
                                                }.onSuccess { items ->
                                                    // TODO show the list
                                                    println("onSuccess: items = $items")
                                                }.onFailure {
                                                    // TODO show error
                                                    println("onFailure")
                                                }
                                            }
                                        },
                                        singleLine = true,
                                        textStyle = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.DarkGray,
                                        ),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(all = 16.dp)
                                            .background(color = Color.White)
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    println("innerPadding = $innerPadding")
                    VehiclesList(vehicles, modifier = Modifier)
//                    TheAppUI(vehicles)
                }
            }
        }
    }
}
