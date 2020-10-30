package com.example.nasaclient.mvp.model.entity.local.dao

import androidx.room.*
import com.example.nasaclient.mvp.model.entity.local.RoomMarsPhoto

@Dao
interface MarsPhotosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(marsPhoto: RoomMarsPhoto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg marsPhotos: RoomMarsPhoto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(marsPhotos: List<RoomMarsPhoto>)

    @Update
    fun update(marsPhoto: RoomMarsPhoto)

    @Update
    fun update(vararg marsPhotos: RoomMarsPhoto)

    @Update
    fun update(marsPhotos: List<RoomMarsPhoto>)

    @Delete
    fun delete(marsPhoto: RoomMarsPhoto)

    @Delete
    fun delete(vararg marsPhotos: RoomMarsPhoto)

    @Delete
    fun delete(marsPhotos: List<RoomMarsPhoto>)

    @Query("SELECT * FROM RoomMarsPhoto")
    fun getMarsPhotos(): List<RoomMarsPhoto>

    @Query("SELECT * FROM RoomMarsPhoto WHERE earth_date =:date")
    fun findByDate(date: String): RoomMarsPhoto
}