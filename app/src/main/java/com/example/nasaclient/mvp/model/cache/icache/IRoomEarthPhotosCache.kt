package com.example.nasaclient.mvp.model.cache.icache

import com.example.nasaclient.mvp.model.entity.local.RoomEarthPhoto
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface IRoomEarthPhotosCache {
    fun getEarthPhotos(): Observable<List<EarthPhoto?>>
    fun insertEarthPhotos(earthPhotos: List<EarthPhoto?>): Completable
}