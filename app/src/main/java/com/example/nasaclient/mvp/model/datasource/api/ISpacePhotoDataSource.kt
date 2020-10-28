package com.example.nasaclient.mvp.model.datasource.api

import com.example.nasaclient.mvp.model.entity.SpacePhoto
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ISpacePhotoDataSource {
    @GET("planetary/apod")
    fun getSpacePhoto(@Query("api_key") apiKey: String): Observable<SpacePhoto>
}