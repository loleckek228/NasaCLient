package com.example.nasaclient.di.module

import com.example.nasaclient.mvp.model.datasource.api.IEarthPhotosDataSource
import com.example.nasaclient.mvp.model.datasource.api.IMarsPhotosDataSource
import com.example.nasaclient.mvp.model.datasource.api.IMarsWeatherDataSource
import com.example.nasaclient.mvp.model.datasource.api.ISpacePhotoDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Named("base_url")
    @Provides
    fun baseUrl() = "https://api.nasa.gov/"

    @Provides
    fun apiEarthPhoto(@Named("base_url") baseUrl: String, gson: Gson): IEarthPhotosDataSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IEarthPhotosDataSource::class.java)

    @Provides
    fun apiMarsPhoto(@Named("base_url") baseUrl: String, gson: Gson): IMarsPhotosDataSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IMarsPhotosDataSource::class.java)

    @Provides
    fun apiMarsWeather(@Named("base_url") baseUrl: String, gson: Gson): IMarsWeatherDataSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IMarsWeatherDataSource::class.java)

    @Provides
    fun apiSpacePhoto(@Named("base_url") baseUrl: String, gson: Gson): ISpacePhotoDataSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ISpacePhotoDataSource::class.java)

    @Singleton
    @Provides
    fun gson() =
        GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()
}