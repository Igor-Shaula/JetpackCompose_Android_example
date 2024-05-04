package com.igor_shaula.complex_api_client_sample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material 3 typography styles to start with
val typography = Typography(

    // used in TopAppBar for Search field content & placeholder
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Start
    ),

    // used in ExplanationScreen for its header
    titleMedium = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center
    ),

    // used in ExplanationScreen for its body
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center
    )
)
