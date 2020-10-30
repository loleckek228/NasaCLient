package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomEarthPhotosCache
import com.example.nasaclient.mvp.model.datasource.local.Database
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import com.example.nasaclient.utils.mapEarthPhotosToRoomEarthPhotos
import com.example.nasaclient.utils.mapRoomEarthPhotosToEarthPhotos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomEarthPhotosCache(val database: Database) : IRoomEarthPhotosCache {
    override fun getEarthPhotos(): Observable<List<EarthPhoto?>> {
        return Observable.fromCallable {
            mapRoomEarthPhotosToEarthPhotos(database.earthPhotosDao().getEarthPhotos())
        }
    }

    override fun insertEarthPhotos(earthPhotos: List<EarthPhoto?>): Completable {
        return Completable.fromAction {
            database.earthPhotosDao().insert(mapEarthPhotosToRoomEarthPhotos(earthPhotos))
        }.subscribeOn(Schedulers.io())
    }
}