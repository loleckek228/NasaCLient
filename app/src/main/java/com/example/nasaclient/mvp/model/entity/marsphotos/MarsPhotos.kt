package com.example.nasaclient.mvp.model.entity.marsphotos

import com.google.gson.annotations.Expose

data class MarsPhotos(
    @Expose val photos: List<MarsPhoto>?
)