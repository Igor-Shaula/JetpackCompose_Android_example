package com.igor_shaula.outdoorsy_android_challenge_task.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.TheAppUI
import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // todo: add app toolbar for later search request
        setContentView(ProgressBar(this))
    }

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

        var searchText by remember { mutableStateOf("") }
//        var password by rememberSaveable { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = Color.Green
                    ),
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
//                                value = searchText,
                                onValueChange = { newText ->
                                    println("onValueChange: new value = $newText")
                                    // TODO: remove all spaces and blank symbols
//                                    searchText = newText
                                    viewModel.updateSearchRequest(newText)
                                },
                                singleLine = true,
//                                maxLines = 1,
                                textStyle = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.DarkGray,
//                                    background = Color.White
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
            TheAppUI(vehicles)
        }
    }
}
