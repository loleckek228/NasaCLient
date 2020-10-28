package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.datasource.api.ApiKey
import com.example.nasaclient.mvp.model.datasource.api.IMarsWeatherDataSource
import com.example.nasaclient.mvp.model.repo.irepo.IMarsWeatherRepo
import com.example.nasaclient.mvp.model.state.MarsWeatherState
import io.reactivex.rxjava3.core.Observable

class MarsWeatherRepo(private val dataSource: IMarsWeatherDataSource) : IMarsWeatherRepo {
    override fun getMarsWeather(): Observable<MarsWeatherState>? {
        return dataSource.getMarsWeather(ApiKey.API_KEY).map { MarsWeatherState.Success(it) }
    }
}