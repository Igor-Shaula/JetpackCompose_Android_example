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

    // used in ExplanationScreen
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = BIG_FONT_SIZE,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center
    ),

    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // used in TopAppBar for Search field content & placeholder
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DEFAULT_FONT_SIZE,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Start
    ),

    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),

    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
