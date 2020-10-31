package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomSpacePhoto

@Dao
interface SpacePhotoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(spacePhoto: RoomSpacePhoto)

    @Query("SELECT * FROM RoomSpacePhoto")
    fun getSpacePhoto(): RoomSpacePhoto
}