package com.example.nasaclient.application

import android.app.Application
import com.example.nasaclient.di.AppComponent
import com.example.nasaclient.di.DaggerAppComponent
import com.example.nasaclient.di.module.AppModule
import com.example.nasaclient.di.module.earthphotos.EarthPhotosSubcomponent
import com.example.nasaclient.di.module.marsphotos.MarsPhotosSubcomponent
import com.example.nasaclient.di.module.marsweather.MarsWeatherSubcomponent
import com.example.nasaclient.di.module.spacephoto.SpacePhotoSubcomponent
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    private var spacePhotoSubcomponent: SpacePhotoSubcomponent? = null
    private var marsPhotosSubcomponent: MarsPhotosSubcomponent? = null
    private var earthPhotosSubcomponent: EarthPhotosSubcomponent? = null
    private var marsWeatherSubcomponent: MarsWeatherSubcomponent? = null

    override fun onCreate() {
        super.onCreate()

        instance = this

        Timber.plant(Timber.DebugTree())

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initSpacePhotoSubcomponent() =
        appComponent.spacePhotoSubcomponent().also {
            spacePhotoSubcomponent = it
        }

    fun releaseSpacePhotoSubcomponent() {
        spacePhotoSubcomponent = null
    }

    fun initMarsPhotosSubcomponent() =
        appComponent.marsPhotosSubcomponent().also {
            marsPhotosSubcomponent = it
        }

    fun releaseMarsPhotosSubcomponent() {
        marsPhotosSubcomponent = null
    }

    fun initEarthPhotosSubcomponent() =
        appComponent.earthPhotosSubcomponent().also {
            earthPhotosSubcomponent = it
        }

    fun releaseEarthPhotosSubcomponent() {
        earthPhotosSubcomponent = null
    }

    fun initMarsWeatherSubcomponent() =
        appComponent.marsWeatherSubcomponent().also {
            marsWeatherSubcomponent = it
        }

    fun releaseMarsWeatherSubcomponent() {
        marsWeatherSubcomponent = null
    }
}