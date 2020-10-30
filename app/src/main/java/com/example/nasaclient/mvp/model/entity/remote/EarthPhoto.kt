package com.example.nasaclient.mvp.model.entity.remote

import com.google.gson.annotations.Expose

data class EarthPhoto(
    @Expose val caption: String?,
    @Expose val date: String?,
    @Expose val image: String?
)