package com.dlolhd.a30daysofwellness.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(topStart = 16.dp, bottomStart = 4.dp, bottomEnd = 16.dp, topEnd = 4.dp),
    large = RoundedCornerShape(16.dp, 8.dp),
    extraLarge = RoundedCornerShape(24.dp)
)
val CutShapes = Shapes(
    extraSmall = CutCornerShape(4.dp),
    small = CutCornerShape(8.dp),
    medium = CutCornerShape(topStart = 16.dp, bottomStart = 4.dp, bottomEnd = 16.dp, topEnd = 4.dp),
    large = CutCornerShape(16.dp, 8.dp),
    extraLarge = CutCornerShape(24.dp)
)