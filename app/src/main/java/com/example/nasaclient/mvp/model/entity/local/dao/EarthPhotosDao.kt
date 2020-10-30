package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomEarthPhoto

@Dao
interface EarthPhotosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(earthPhoto: RoomEarthPhoto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg earthPhotos: RoomEarthPhoto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(earthPhotos: List<RoomEarthPhoto>)

    @Update
    fun update(earthPhoto: RoomEarthPhoto)

    @Update
    fun update(vararg earthPhotos: RoomEarthPhoto)

    @Update
    fun update(earthPhotos: List<RoomEarthPhoto>)

    @Delete
    fun delete(earthPhoto: RoomEarthPhoto)

    @Delete
    fun delete(vararg earthPhotos: RoomEarthPhoto)

    @Delete
    fun delete(earthPhotos: List<RoomEarthPhoto>)

    @Query("SELECT * FROM RoomEarthPhoto")
    fun getEarthPhotos(): List<RoomEarthPhoto>

    @Query("SELECT * FROM RoomEarthPhoto WHERE date =:date")
    fun findByDate(date: String): RoomEarthPhoto
}