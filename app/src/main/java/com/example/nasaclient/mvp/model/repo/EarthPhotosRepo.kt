package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.core.Observable

class EarthPhotosRepo(
    private val dataSource: IDataSource,
    private val earthPhotosCache: IRoomCache<List<EarthPhoto?>>
) : IRepo<EarthPhotosState> {
    override fun getData(): Observable<EarthPhotosState> {
        return if (isNetworkAvailable()) {
            dataSource.getEarthPhotos(ApiKey.API_KEY).map {
                earthPhotosCache.insertData(it).subscribe()
                EarthPhotosState.Success(it)
            }
        } else {
            earthPhotosCache.getData().map { EarthPhotosState.Success(it) }
        }
    }
}