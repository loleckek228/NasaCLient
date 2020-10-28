package com.example.nasaclient.mvp.model.datasource.api

import com.example.nasaclient.mvp.model.entity.EarthPhoto
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IEarthPhotosDataSource {
    @GET("EPIC/api/natural/images")
    fun getEarthPhotos(@Query("api_key") apiKey: String): Observable<List<EarthPhoto>>
}