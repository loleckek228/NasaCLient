package com.example.nasaclient.mvp.model.entity.marsphotos

import com.google.gson.annotations.Expose

data class MarsPhoto(
    @Expose val camera: MarsCamera?,
    @Expose val earth_date: String?,
    @Expose val img_src: String?,
    @Expose val sol: Int?
)