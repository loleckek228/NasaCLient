package com.example.nasaclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class SpacePhoto(
    @Expose val title: String?,
    @Expose val date: String?,
    @Expose val explanation: String?,
    @Expose val hdurl: String?
)