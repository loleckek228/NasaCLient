package com.example.nasaclient.mvp.model.repo.irepo

import com.example.nasaclient.mvp.model.state.EarthPhotosState
import io.reactivex.rxjava3.core.Observable

interface IEarthPhotosRepo {
    fun getEarthPhotos(): Observable<EarthPhotosState>
}