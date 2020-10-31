package com.example.nasaclient.di.module.marsphotos.module

import com.example.nasaclient.di.module.marsphotos.MarsPhotosScope
import com.example.nasaclient.mvp.model.cache.RoomMarsPhotosCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import com.example.nasaclient.mvp.model.repo.MarsPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import dagger.Module
import dagger.Provides

@Module
open class MarsPhotosRepoModule {
    @MarsPhotosScope
    @Provides
    fun marsPhotosRepo(
        dataSource: IDataSource,
        marsPhotosCache: IRoomCache<MarsPhotos>
    ): IRepo<MarsPhotosState> =
        MarsPhotosRepo(dataSource, marsPhotosCache)

    @Provides
    fun marsPhotosCache(database: Database): IRoomCache<MarsPhotos> =
        RoomMarsPhotosCache(database)
}