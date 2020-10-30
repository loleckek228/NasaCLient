package com.example.nasaclient.mvp.model.entity.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomSpacePhoto(
    @field:PrimaryKey @NonNull
    @field:ColumnInfo(name = "date")
    val date: String,

    @field:ColumnInfo(name = "explanation")
    val explanation: String,

    @field:ColumnInfo(name = "hdurl")
    val hdurl: String,

    @field:ColumnInfo(name = "title")
    val title: String
)