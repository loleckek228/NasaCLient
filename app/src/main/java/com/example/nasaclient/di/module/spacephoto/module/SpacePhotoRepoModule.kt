package com.example.nasaclient.di.module.spacephoto.module

import com.example.nasaclient.di.module.spacephoto.SpacePhotoScope
import com.example.nasaclient.mvp.model.cache.RoomSpacePhotoCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomSpacePhotoCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.ISpacePhotoDataSource
import com.example.nasaclient.mvp.model.network.INetworkStatus
import com.example.nasaclient.mvp.model.repo.SpacePhotoRepo
import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import dagger.Module
import dagger.Provides

@Module
open class SpacePhotoRepoModule {
    @SpacePhotoScope
    @Provides
    fun spacePhotoRepo(
        dataSource: ISpacePhotoDataSource,
        spacePhotoCache: IRoomSpacePhotoCache
    ): ISpacePhotoRepo =
        SpacePhotoRepo(dataSource, spacePhotoCache)

    @Provides
    fun spacePhotoCache(database: Database): IRoomSpacePhotoCache =
        RoomSpacePhotoCache(database)
}