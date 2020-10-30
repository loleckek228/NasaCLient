package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomSpacePhotoCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import com.example.nasaclient.utils.mapRoomSpacePhotoToSpacePhoto
import com.example.nasaclient.utils.mapSpacePhotoToRoomSpacePhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomSpacePhotoCache(val database: Database) : IRoomSpacePhotoCache {
    override fun getSpacePhoto(): Observable<SpacePhoto?> {
        return Observable.fromCallable {
            mapRoomSpacePhotoToSpacePhoto(database.spacePhotoDao().getSpacePhoto())
        }
    }

    override fun insertSpacePhoto(spacePhoto: SpacePhoto?): Completable {
        return Completable.fromAction {
            database.spacePhotoDao().insert(mapSpacePhotoToRoomSpacePhoto(spacePhoto))
        }.subscribeOn(Schedulers.io())
    }
}