package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import com.example.nasaclient.utils.getYestardayDateString
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.core.Observable

class MarsPhotosRepo(
    private val dataSource: IDataSource,
    private val marsPhotosCache: IRoomCache<MarsPhotos>,
) : IRepo<MarsPhotosState> {
    override fun getData(): Observable<MarsPhotosState> {
        return if (isNetworkAvailable()) {
            dataSource.getMarsPhotos(getYestardayDateString(), ApiKey.API_KEY)
                .map {
                    marsPhotosCache.insertData(it).subscribe()
                    MarsPhotosState.Success(it)
                }
        } else {
            marsPhotosCache.getData().map { MarsPhotosState.Success(it) }
        }
    }
}