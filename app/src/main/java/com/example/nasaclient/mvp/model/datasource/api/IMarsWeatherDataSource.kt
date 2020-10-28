package com.example.nasaclient.mvp.model.datasource.api

import com.example.nasaclient.mvp.model.entity.MarsWeather
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarsWeatherDataSource {
    @GET("insight_weather/")
    fun getMarsWeather(@Query("api_key") apiKey: String): Observable<List<MarsWeather>>
}