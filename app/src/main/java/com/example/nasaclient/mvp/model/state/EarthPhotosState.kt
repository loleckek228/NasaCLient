package com.example.nasaclient.mvp.model.state

import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto

sealed class EarthPhotosState {
    data class Error(val error: Throwable?) : EarthPhotosState()
    data class Loading(val progress: Int?) : EarthPhotosState()
    data class Success(val data: List<EarthPhoto?>?) : EarthPhotosState()
}