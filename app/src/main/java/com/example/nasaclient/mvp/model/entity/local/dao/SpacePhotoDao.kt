package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomSpacePhoto

@Dao
interface SpacePhotoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(spacePhoto: RoomSpacePhoto)

    @Update
    fun update(spacePhoto: RoomSpacePhoto)

    @Delete
    fun delete(spacePhoto: RoomSpacePhoto)

    @Query("SELECT * FROM RoomSpacePhoto")
    fun getSpacePhoto(): RoomSpacePhoto

    @Query("SELECT * FROM RoomSpacePhoto WHERE date =:date")
    fun findByDate(date: String): RoomSpacePhoto
}