package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos
import com.example.nasaclient.mvp.model.utils.mapMarsPhotosToRoomMarsPhotos
import com.example.nasaclient.mvp.model.utils.mapRoomMarsPhotosToMarsPhotos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class RoomMarsPhotosCache(val database: Database) : IRoomCache<MarsPhotos> {
    override fun getData(): Observable<MarsPhotos?> {
        return Observable.fromCallable {
            mapRoomMarsPhotosToMarsPhotos(database.marsPhotosDao().getMarsPhotos())
        }
    }

    override fun insertData(data: MarsPhotos): Completable {
        return Completable.fromAction {
            database.marsPhotosDao().insert(mapMarsPhotosToRoomMarsPhotos(data.photos))
        }
    }
}