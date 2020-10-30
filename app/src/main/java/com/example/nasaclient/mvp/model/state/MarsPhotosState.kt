package com.example.nasaclient.mvp.model.state

import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos

sealed class MarsPhotosState {
    data class Error(val error: Throwable?) : MarsPhotosState()
    data class Loading(val progress: Int?) : MarsPhotosState()
    data class Success(val data: MarsPhotos?) : MarsPhotosState()
}