package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomEarthPhotosCache
import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsWeatherCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IMarsWeatherDataSource
import com.example.nasaclient.mvp.model.network.INetworkStatus
import com.example.nasaclient.mvp.model.repo.irepo.IMarsWeatherRepo
import com.example.nasaclient.mvp.model.state.MarsWeatherState
import io.reactivex.rxjava3.core.Observable

class MarsWeatherRepo(
    private val dataSource: IMarsWeatherDataSource,
    private val marsWeatherCache: IRoomMarsWeatherCache
) : IMarsWeatherRepo {
    override fun getMarsWeather(): Observable<MarsWeatherState> {
        val sols = mutableListOf<String>()
//
//        dataSource.getSols(ApiKey.API_KEY).map {
//            sols.addAll(it.sol_keys)
//        }

//        val hashMap: Map<String, MarsWeatherRoot> = mutableMapOf()

        return dataSource.getMarsWeather(ApiKey.API_KEY)
            .map { MarsWeatherState.Success(it) }
    }
}