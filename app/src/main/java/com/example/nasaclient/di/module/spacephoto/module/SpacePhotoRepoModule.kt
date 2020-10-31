package com.example.nasaclient.di.module.spacephoto.module

import com.example.nasaclient.di.module.spacephoto.SpacePhotoScope
import com.example.nasaclient.mvp.model.cache.RoomSpacePhotoCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import com.example.nasaclient.mvp.model.repo.SpacePhotoRepo
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import dagger.Module
import dagger.Provides

@Module
open class SpacePhotoRepoModule {
    @SpacePhotoScope
    @Provides
    fun spacePhotoRepo(
        dataSource: IDataSource,
        spacePhotoCache: IRoomCache<SpacePhoto>
    ): IRepo<SpacePhotoState> =
        SpacePhotoRepo(dataSource, spacePhotoCache)

    @Provides
    fun spacePhotoCache(database: Database): IRoomCache<SpacePhoto> =
        RoomSpacePhotoCache(database)
}