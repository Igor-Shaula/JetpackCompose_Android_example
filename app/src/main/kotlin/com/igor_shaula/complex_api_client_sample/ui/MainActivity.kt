package com.igor_shaula.complex_api_client_sample.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.igor_shaula.complex_api_client_sample.ui.elements.TheAppScreen
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
//        enableEdgeToEdge() // no need to enable this - but let it stay here as an option for the future
        setContent {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                TheAppTheme {
                    TheAppScreen(::hideKeyboard)
                }
            }
        }
    }

    // to hide keyboard on scroll events
    private fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
