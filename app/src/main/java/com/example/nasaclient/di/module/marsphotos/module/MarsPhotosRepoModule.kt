package com.example.nasaclient.di.module.marsphotos.module

import com.example.nasaclient.di.module.marsphotos.MarsPhotosScope
import com.example.nasaclient.mvp.model.cache.RoomMarsPhotosCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsPhotosCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IMarsPhotosDataSource
import com.example.nasaclient.mvp.model.repo.MarsPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IMarsPhotosRepo
import com.example.nasaclient.ui.network.AndroidNetworkStatus
import dagger.Module
import dagger.Provides

@Module
open class MarsPhotosRepoModule {
    @MarsPhotosScope
    @Provides
    fun marsPhotosRepo(
        dataSource: IMarsPhotosDataSource,
        marsPhotosCache: IRoomMarsPhotosCache
    ): IMarsPhotosRepo =
        MarsPhotosRepo(dataSource, marsPhotosCache)

    @Provides
    fun marsPhotosCache(database: Database): IRoomMarsPhotosCache =
        RoomMarsPhotosCache(database)
}