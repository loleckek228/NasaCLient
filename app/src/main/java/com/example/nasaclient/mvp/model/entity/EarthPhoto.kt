package com.example.nasaclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class EarthPhoto(
    @Expose val caption: String?,
    @Expose val image: String?,
    @Expose val date: String?
)