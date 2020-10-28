package com.example.nasaclient.mvp.model.repo.irepo

import com.example.nasaclient.mvp.model.state.SpacePhotoState
import io.reactivex.rxjava3.core.Observable

interface ISpacePhotoRepo {
    fun getSpacePhoto(): Observable<SpacePhotoState>
}