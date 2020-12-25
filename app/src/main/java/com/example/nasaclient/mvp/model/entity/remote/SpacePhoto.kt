package com.example.nasaclient.mvp.model.entity.remote

import com.google.gson.annotations.Expose

data class SpacePhoto(
    @Expose val date: String?,
    @Expose val explanation: String?,
    @Expose val hdurl: String?,
    @Expose val title: String?
)