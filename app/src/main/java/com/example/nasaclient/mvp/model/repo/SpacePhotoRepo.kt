package com.example.nasaclient.mvp.model.repo

import com.example.nasaclient.mvp.model.datasource.api.ApiKey
import com.example.nasaclient.mvp.model.datasource.api.ISpacePhotoDataSource
import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import io.reactivex.rxjava3.core.Observable

class SpacePhotoRepo(
    private val dataSource: ISpacePhotoDataSource
) : ISpacePhotoRepo {
    override fun getSpacePhoto(): Observable<SpacePhotoState> {
        return dataSource.getSpacePhoto(ApiKey.API_KEY).map { SpacePhotoState.Success(it) }
    }
}