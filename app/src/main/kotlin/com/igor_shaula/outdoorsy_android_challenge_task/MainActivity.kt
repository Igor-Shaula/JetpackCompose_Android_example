package com.igor_shaula.outdoorsy_android_challenge_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.TheAppUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val theList = listOf("1", "2", "3")
        setContent { TheAppUI(theList) }
    }
}
