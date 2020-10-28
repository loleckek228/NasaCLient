package com.example.nasaclient.mvp.model.repo.irepo

import com.example.nasaclient.mvp.model.state.MarsPhotosState
import io.reactivex.rxjava3.core.Observable

interface IMarsPhotosRepo {
    fun getMarsPhotos(): Observable<MarsPhotosState>
}