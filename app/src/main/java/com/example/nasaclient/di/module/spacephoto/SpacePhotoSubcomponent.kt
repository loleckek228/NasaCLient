package com.example.nasaclient.di.module.spacephoto

import com.example.nasaclient.di.module.spacephoto.module.SpacePhotoRepoModule
import com.example.nasaclient.mvp.model.repo.SpacePhotoRepo
import com.example.nasaclient.mvp.presenter.SpacePhotoPresenter
import dagger.Subcomponent

@SpacePhotoScope
@Subcomponent(
    modules = [
        SpacePhotoRepoModule::class
    ]
)
interface SpacePhotoSubcomponent {
    fun inject(spacePhotoPresenter: SpacePhotoPresenter)
}