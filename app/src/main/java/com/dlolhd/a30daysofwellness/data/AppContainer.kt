package com.dlolhd.a30daysofwellness.data

import com.dlolhd.a30daysofwellness.model.WellnessLocalRepository
import com.dlolhd.a30daysofwellness.model.WellnessRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val wellnessRepository: WellnessRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    override val wellnessRepository: WellnessRepository by lazy {
        WellnessLocalRepository()
    }
}