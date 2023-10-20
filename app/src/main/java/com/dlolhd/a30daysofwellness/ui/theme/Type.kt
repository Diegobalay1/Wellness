package com.dlolhd.a30daysofwellness.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dlolhd.a30daysofwellness.R

val SrirachaRegular = FontFamily(
    Font(R.font.sriracha_regular, FontWeight.Bold),
    Font(R.font.sriracha_regular, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
    fontFamily = SrirachaRegular,
    fontWeight = FontWeight.SemiBold,
    fontSize = 36.sp
),
    displayMedium = TextStyle(
    fontFamily = SrirachaRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
),
    labelSmall = TextStyle(
    fontFamily = SrirachaRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
),
    bodyLarge = TextStyle(
    fontFamily = SrirachaRegular,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
),
    displaySmall = TextStyle(
    fontFamily = SrirachaRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)
)