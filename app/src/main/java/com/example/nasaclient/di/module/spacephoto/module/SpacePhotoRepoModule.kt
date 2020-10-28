package com.example.nasaclient.di.module.spacephoto.module

import com.example.nasaclient.di.module.spacephoto.SpacePhotoScope
import com.example.nasaclient.mvp.model.datasource.api.ISpacePhotoDataSource
import com.example.nasaclient.mvp.model.repo.SpacePhotoRepo
import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import dagger.Module
import dagger.Provides

@Module
open class SpacePhotoRepoModule {
    @SpacePhotoScope
    @Provides
    fun spacePhotoRepo(dataSource: ISpacePhotoDataSource): ISpacePhotoRepo = SpacePhotoRepo(dataSource)
}