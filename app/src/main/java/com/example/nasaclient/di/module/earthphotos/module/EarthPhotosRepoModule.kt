package com.example.nasaclient.di.module.earthphotos.module

import com.example.nasaclient.di.module.earthphotos.EarthPhotosScope
import com.example.nasaclient.mvp.model.cache.RoomEarthPhotosCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import com.example.nasaclient.mvp.model.repo.EarthPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import dagger.Module
import dagger.Provides

@Module
class EarthPhotosRepoModule {
    @EarthPhotosScope
    @Provides
    fun earthPhotosRepo(
        dataSource: IDataSource,
        earthPhotosCache: IRoomCache<List<EarthPhoto?>>
    ): IRepo<EarthPhotosState> =
        EarthPhotosRepo(dataSource, earthPhotosCache)

    @Provides
    fun earthPhotosCache(database: Database): IRoomCache<List<EarthPhoto?>> =
        RoomEarthPhotosCache(database)
}