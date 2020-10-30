package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomEarthPhotosCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IEarthPhotosDataSource
import com.example.nasaclient.mvp.model.repo.irepo.IEarthPhotosRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.core.Observable

class EarthPhotosRepo(
    private val dataSource: IEarthPhotosDataSource,
    private val earthPhotosCache: IRoomEarthPhotosCache
) : IEarthPhotosRepo {
    override fun getEarthPhotos(): Observable<EarthPhotosState> {
        return if (isNetworkAvailable()) {
            dataSource.getEarthPhotos(ApiKey.API_KEY).map {
                earthPhotosCache.insertEarthPhotos(it).subscribe()
                EarthPhotosState.Success(it)
            }
        } else {
            earthPhotosCache.getEarthPhotos().map { EarthPhotosState.Success(it) }
        }
    }
}