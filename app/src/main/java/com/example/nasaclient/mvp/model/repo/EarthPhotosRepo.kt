package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.datasource.api.ApiKey
import com.example.nasaclient.mvp.model.datasource.api.IEarthPhotosDataSource
import com.example.nasaclient.mvp.model.repo.irepo.IEarthPhotosRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import io.reactivex.rxjava3.core.Observable

class EarthPhotosRepo(
    private val dataSource: IEarthPhotosDataSource
) : IEarthPhotosRepo {
    override fun getEarthPhotos(): Observable<EarthPhotosState> {
        return dataSource.getEarthPhotos(ApiKey.API_KEY).map { EarthPhotosState.Success(it) }
    }
}