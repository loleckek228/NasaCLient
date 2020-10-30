package com.example.nasaclient.mvp.model.entity.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomEarthPhoto(
    @field:ColumnInfo(name = "caption")
    val caption: String,

    @field:PrimaryKey @NonNull
    @field:ColumnInfo(name = "date")
    val date: String,

    @field:ColumnInfo(name = "image")
    val image: String
)