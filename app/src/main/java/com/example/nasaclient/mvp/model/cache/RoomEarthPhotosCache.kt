package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import com.example.nasaclient.mvp.model.utils.mapEarthPhotosToRoomEarthPhotos
import com.example.nasaclient.mvp.model.utils.mapRoomEarthPhotosToEarthPhotos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class RoomEarthPhotosCache(val database: Database) : IRoomCache<List<EarthPhoto?>> {
    override fun insertData(data: List<EarthPhoto?>): Completable {
        return Completable.fromAction {
            database.earthPhotosDao().insert(mapEarthPhotosToRoomEarthPhotos(data))
        }
    }

    override fun getData(): Observable<List<EarthPhoto?>?> {
        return Observable.fromCallable {
            mapRoomEarthPhotosToEarthPhotos(database.earthPhotosDao().getEarthPhotos())
        }
    }
}