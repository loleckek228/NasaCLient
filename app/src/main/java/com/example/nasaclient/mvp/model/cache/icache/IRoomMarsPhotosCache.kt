package com.example.nasaclient.mvp.model.cache.icache

import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface IRoomMarsPhotosCache {
    fun getMarsPhotos(): Observable<MarsPhotos?>
    fun insertMarsPhotos(marsPhotos: MarsPhotos): Completable
}