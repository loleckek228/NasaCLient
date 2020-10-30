package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsPhotosCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import com.example.nasaclient.utils.mapMarsPhotosToRoomMarsPhotos
import com.example.nasaclient.utils.mapRoomMarsPhotosToMarsPhotos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomMarsPhotosCache(val database: Database) : IRoomMarsPhotosCache {
    override fun getMarsPhotos(): Observable<MarsPhotos?> {
        return Observable.fromCallable {
            mapRoomMarsPhotosToMarsPhotos(database.marsPhotosDao().getMarsPhotos())
        }
    }

    override fun insertMarsPhotos(marsPhotos: MarsPhotos): Completable {
        return Completable.fromAction {
            database.marsPhotosDao().insert(mapMarsPhotosToRoomMarsPhotos(marsPhotos.photos))
        }.subscribeOn(Schedulers.io())
    }
}