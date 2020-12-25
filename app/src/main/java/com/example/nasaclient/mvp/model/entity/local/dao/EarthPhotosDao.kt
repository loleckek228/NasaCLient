package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomEarthPhoto

@Dao
interface EarthPhotosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(earthPhotos: List<RoomEarthPhoto>)

    @Query("SELECT * FROM RoomEarthPhoto")
    fun getEarthPhotos(): List<RoomEarthPhoto>
}