package com.dlolhd.a30daysofwellness

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dlolhd.a30daysofwellness.WellnessApplication
import com.dlolhd.a30daysofwellness.ui.view.WellnessViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Wellness app
 */
object WellnessAppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for WellnessViewModel
        initializer {
            WellnessViewModel(wellnessApplication().container.wellnessRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [WellnessApplication].
 */
fun CreationExtras.wellnessApplication(): WellnessApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as WellnessApplication)
