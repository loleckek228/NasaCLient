package com.example.nasaclient.mvp.model.entity.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomMarsPhoto(
    @field:ColumnInfo(name = "camera")
    val camera: String,

    @field:ColumnInfo(name = "earth_date")
    val earth_date: String,

    @field:PrimaryKey @NonNull
    @field:ColumnInfo(name = "img_src")
    val img_src: String,

    @field:ColumnInfo(name = "sol")
    val sol: Int
)