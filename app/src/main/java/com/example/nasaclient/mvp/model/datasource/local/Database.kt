package com.example.nasaclient.mvp.model.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasaclient.mvp.model.entity.local.RoomEarthPhoto
import com.example.nasaclient.mvp.model.entity.local.RoomMarsPhoto
import com.example.nasaclient.mvp.model.entity.local.RoomSpacePhoto
import com.example.nasaclient.mvp.model.entity.local.dao.EarthPhotosDao
import com.example.nasaclient.mvp.model.entity.local.dao.MarsPhotosDao
import com.example.nasaclient.mvp.model.entity.local.dao.SpacePhotoDao

@Database(
    entities = [
        RoomEarthPhoto::class,
        RoomMarsPhoto::class,
        RoomSpacePhoto::class
    ],
    version = 1,
    exportSchema = false
)

abstract class Database : RoomDatabase() {
    companion object {
        const val DB_NAME = "database.db"
    }

    abstract fun earthPhotosDao(): EarthPhotosDao
    abstract fun marsPhotosDao(): MarsPhotosDao
    abstract fun spacePhotoDao(): SpacePhotoDao
}