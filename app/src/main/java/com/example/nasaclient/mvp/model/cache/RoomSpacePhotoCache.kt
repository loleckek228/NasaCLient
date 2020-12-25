package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import com.example.nasaclient.mvp.model.utils.mapRoomSpacePhotoToSpacePhoto
import com.example.nasaclient.mvp.model.utils.mapSpacePhotoToRoomSpacePhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class RoomSpacePhotoCache(val database: Database) : IRoomCache<SpacePhoto> {
    override fun getData(): Observable<SpacePhoto?> {
        return Observable.fromCallable {
            mapRoomSpacePhotoToSpacePhoto(database.spacePhotoDao().getSpacePhoto())
        }
    }

    override fun insertData(data: SpacePhoto): Completable {
        return Completable.fromAction {
            database.spacePhotoDao().insert(mapSpacePhotoToRoomSpacePhoto(data))
        }
    }
}