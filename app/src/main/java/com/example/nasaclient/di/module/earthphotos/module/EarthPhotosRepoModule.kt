package com.example.nasaclient.di.module.earthphotos.module

import com.example.nasaclient.di.module.earthphotos.EarthPhotosScope
import com.example.nasaclient.mvp.model.cache.RoomEarthPhotosCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomEarthPhotosCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IEarthPhotosDataSource
import com.example.nasaclient.mvp.model.network.INetworkStatus
import com.example.nasaclient.mvp.model.repo.EarthPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IEarthPhotosRepo
import dagger.Module
import dagger.Provides

@Module
class EarthPhotosRepoModule {
    @EarthPhotosScope
    @Provides
    fun earthPhotosRepo(
        dataSource: IEarthPhotosDataSource,
        earthPhotosCache: IRoomEarthPhotosCache
    ): IEarthPhotosRepo =
        EarthPhotosRepo(dataSource, earthPhotosCache)

    @Provides
    fun earthPhotosCache(database: Database): IRoomEarthPhotosCache =
        RoomEarthPhotosCache(database)
}