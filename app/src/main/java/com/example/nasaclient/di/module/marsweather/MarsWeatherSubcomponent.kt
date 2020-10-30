package com.example.nasaclient.di.module.marsweather

import com.example.nasaclient.di.module.marsweather.module.MarsWeatherRepoModule
import com.example.nasaclient.mvp.model.repo.MarsWeatherRepo
import com.example.nasaclient.mvp.presenter.MarsWeatherPresenter
import dagger.Subcomponent

@MarsWeatherScope
@Subcomponent(
    modules = [
        MarsWeatherRepoModule::class
    ]
)

interface MarsWeatherSubcomponent {
    fun inject(marsWeatherPresenter: MarsWeatherPresenter)
}