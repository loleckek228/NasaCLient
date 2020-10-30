package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsPhotosCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IMarsPhotosDataSource
import com.example.nasaclient.mvp.model.repo.irepo.IMarsPhotosRepo
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import com.example.nasaclient.utils.getYestardayDateString
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable

class MarsPhotosRepo(
    private val dataSource: IMarsPhotosDataSource,
    private val marsPhotosCache: IRoomMarsPhotosCache,
) : IMarsPhotosRepo {
    override fun getMarsPhotos(): Observable<MarsPhotosState> {
        return if (isNetworkAvailable()) {
            dataSource.getMarsPhotos(getYestardayDateString(), ApiKey.API_KEY)
                .map {
                    marsPhotosCache.insertMarsPhotos(it).subscribe()
                    MarsPhotosState.Success(it)
                }
        } else {
            marsPhotosCache.getMarsPhotos().map { MarsPhotosState.Success(it) }
        }
    }
}