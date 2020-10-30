package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomSpacePhotoCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.ISpacePhotoDataSource
import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable

class SpacePhotoRepo(
    private val dataSource: ISpacePhotoDataSource,
    private val spacePhotoCache: IRoomSpacePhotoCache
) : ISpacePhotoRepo {
    override fun getSpacePhoto(): Observable<SpacePhotoState> {
        return if (isNetworkAvailable()) {
            dataSource.getSpacePhoto(ApiKey.API_KEY).map {
                spacePhotoCache.insertSpacePhoto(it).subscribe()
                SpacePhotoState.Success(it)
            }
        } else {
            spacePhotoCache.getSpacePhoto().map { SpacePhotoState.Success(it) }
        }
    }
}