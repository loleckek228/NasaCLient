package com.example.nasaclient.di.module.marsweather.module

import com.example.nasaclient.di.module.marsweather.MarsWeatherScope
import com.example.nasaclient.mvp.model.cache.RoomMarsWeatherCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsWeatherCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.datasource.remote.IMarsWeatherDataSource
import com.example.nasaclient.mvp.model.network.INetworkStatus
import com.example.nasaclient.mvp.model.repo.MarsWeatherRepo
import com.example.nasaclient.mvp.model.repo.irepo.IMarsWeatherRepo
import dagger.Module
import dagger.Provides

@Module
open class MarsWeatherRepoModule {
    @MarsWeatherScope
    @Provides
    fun marsWeatherRepo(
        dataSource: IMarsWeatherDataSource,
        marsWeatherCache: IRoomMarsWeatherCache
    ): IMarsWeatherRepo =
        MarsWeatherRepo(dataSource, marsWeatherCache)

    @Provides
    fun matsWeatherCache(database: Database): IRoomMarsWeatherCache =
        RoomMarsWeatherCache(database)
}