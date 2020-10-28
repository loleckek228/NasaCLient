package com.example.nasaclient.di.module.earthphotos

import com.example.nasaclient.di.module.earthphotos.module.EarthPhotosRepoModule
import com.example.nasaclient.mvp.presenter.EarthPhotosPresenter
import dagger.Subcomponent

@EarthPhotosScope
@Subcomponent(
    modules = [
        EarthPhotosRepoModule::class
    ]
)

interface EarthPhotosSubcomponent {
    fun inject(earthPhotosPresenter: EarthPhotosPresenter)
}