package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.remote.ApiKey
import com.example.nasaclient.mvp.model.datasource.remote.IDataSource
import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.utils.network.isNetworkAvailable
import io.reactivex.rxjava3.core.Observable

class SpacePhotoRepo(
    private val dataSource: IDataSource,
    private val spacePhotoCache: IRoomCache<SpacePhoto>
) : IRepo<SpacePhotoState> {
    override fun getData(): Observable<SpacePhotoState> {
        return if (isNetworkAvailable()) {
            dataSource.getSpacePhoto(ApiKey.API_KEY).map {
                spacePhotoCache.insertData(it).subscribe()
                SpacePhotoState.Success(it)
            }
        } else {
            spacePhotoCache.getData().map { SpacePhotoState.Success(it) }
        }
    }
}