package com.example.nasaclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class MarsPhoto(
    @Expose val sol: Int,
    @Expose val earth_date: String?,
    @Expose val img_src: String?,
    @Expose val camera: MarsCamera?
)