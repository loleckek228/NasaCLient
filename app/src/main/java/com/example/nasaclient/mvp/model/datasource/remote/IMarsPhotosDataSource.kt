package com.example.nasaclient.mvp.model.datasource.remote

import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarsPhotosDataSource {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getMarsPhotos(
        @Query("earth_date") earthDate: String,
        @Query("api_key") apiKey: String
    ): Observable<MarsPhotos>
}