package com.example.nasaclient.di.module.marsphotos

import com.example.nasaclient.di.module.marsphotos.module.MarsPhotosRepoModule
import com.example.nasaclient.mvp.presenter.MarsPhotosPresenter
import dagger.Subcomponent


@MarsPhotosScope
@Subcomponent(
    modules = [
        MarsPhotosRepoModule::class
    ]
)
interface MarsPhotosSubcomponent {
    fun inject(marsPhotosPresenter: MarsPhotosPresenter)
}