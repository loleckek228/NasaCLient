package com.example.nasaclient.mvp.model.repo.irepo

import com.example.nasaclient.mvp.model.state.MarsWeatherState
import io.reactivex.rxjava3.core.Observable

interface IMarsWeatherRepo {
    fun getMarsWeather(): Observable<MarsWeatherState>
}