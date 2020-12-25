package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomMarsPhoto

@Dao
interface MarsPhotosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(marsPhotos: List<RoomMarsPhoto>)

    @Query("SELECT * FROM RoomMarsPhoto")
    fun getMarsPhotos(): List<RoomMarsPhoto>
}