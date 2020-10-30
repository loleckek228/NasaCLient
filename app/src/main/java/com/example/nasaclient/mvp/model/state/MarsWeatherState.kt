package com.example.nasaclient.mvp.model.state

import com.example.nasaclient.mvp.model.entity.remote.marsweather.MarsWeatherSol

sealed class MarsWeatherState {
    data class Error(val error: Throwable?) : MarsWeatherState()
    data class Loading(val progress: Int?) : MarsWeatherState()
    data class Success(val data: Map<String, MarsWeatherSol>?) : MarsWeatherState()
}