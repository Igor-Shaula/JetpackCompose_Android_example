package com.igor_shaula.complex_api_client_sample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.igor_shaula.complex_api_client_sample.R

val SourceSans3Regular = FontFamily(Font(R.font.source_sans3_regular))

val SourceCodeProMedium = FontFamily(Font(R.font.source_code_pro_medium))

// Set of Material 3 typography styles to start with
val typography = Typography(

    // used in TopAppBar for Search field content & placeholder
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = SourceSans3Regular,
        textAlign = TextAlign.Start
    ),

    // used in ExplanationScreen for its header
    titleMedium = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = SourceSans3Regular,
        textAlign = TextAlign.Center
    ),

    // used in ExplanationScreen for its body
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = SourceSans3Regular,
        textAlign = TextAlign.Center
    ),

    // used in ExplanationScreen for its body
    bodySmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = SourceCodeProMedium,
        textAlign = TextAlign.Center
    )
)
