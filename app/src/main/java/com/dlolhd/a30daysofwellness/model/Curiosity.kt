package com.dlolhd.a30daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Curiosity(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val imgRes: Int,
    @StringRes val description: Int
)
