package com.example.nasaclient.mvp.model.datasource.remote

import com.example.nasaclient.mvp.model.entity.remote.marsweather.MarsWeatherSol
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface IMarsWeatherDataSource {
    //@FormUrlEncoded
    @GET("insight_weather/")
    fun getMarsWeather(
        @Query("api_key") apiKey: String,
    ): Observable<Map<String, MarsWeatherSol>>
}