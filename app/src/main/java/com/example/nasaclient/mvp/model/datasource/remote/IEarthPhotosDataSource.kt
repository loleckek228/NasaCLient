package com.example.nasaclient.mvp.model.datasource.remote

import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IEarthPhotosDataSource {
    @GET("EPIC/api/natural/images")
    fun getEarthPhotos(@Query("api_key") apiKey: String): Observable<List<EarthPhoto>>
}