package com.example.nasaclient.mvp.model.cache.icache

import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface IRoomSpacePhotoCache {
    fun getSpacePhoto(): Observable<SpacePhoto?>
    fun insertSpacePhoto(spacePhoto: SpacePhoto?): Completable
}