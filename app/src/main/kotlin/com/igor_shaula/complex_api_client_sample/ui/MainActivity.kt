package com.igor_shaula.complex_api_client_sample.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppScreen
import com.igor_shaula.complex_api_client_sample.ui.previews.ThemeWithSurface
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

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // no need to enable this - but let it stay here as an option for the future
        setContent {
            ThemeWithSurface {
                val windowsSize = calculateWindowSizeClass(this)
                TheAppScreen(::hideKeyboard, windowsSize.widthSizeClass)
            }
        }
    }

    // to hide keyboard on scroll events
    private fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val viewWithCurrentFocus = currentFocus ?: View(this)
        imm.hideSoftInputFromWindow(viewWithCurrentFocus.windowToken, 0)
    }
}
