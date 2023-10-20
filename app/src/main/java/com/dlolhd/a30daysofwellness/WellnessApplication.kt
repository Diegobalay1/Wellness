package com.dlolhd.a30daysofwellness

import android.app.Application
import com.dlolhd.a30daysofwellness.data.AppContainer
import com.dlolhd.a30daysofwellness.data.DefaultAppContainer

class WellnessApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}