package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.datasource.api.ApiKey
import com.example.nasaclient.mvp.model.datasource.api.IMarsPhotosDataSource
import com.example.nasaclient.mvp.model.repo.irepo.IMarsPhotosRepo
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import com.example.nasaclient.utils.getYestardayDateString
import io.reactivex.rxjava3.core.Observable

class MarsPhotosRepo(
    private val dataSource: IMarsPhotosDataSource
) : IMarsPhotosRepo {
    override fun getMarsPhotos(): Observable<MarsPhotosState> {
        return dataSource.getMarsPhotos(getYestardayDateString(), ApiKey.API_KEY)
            .map { MarsPhotosState.Success(it) }
    }
}