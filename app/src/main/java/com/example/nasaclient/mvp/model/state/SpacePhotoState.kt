package com.example.nasaclient.mvp.model.state

import com.example.nasaclient.mvp.model.entity.SpacePhoto

sealed class SpacePhotoState {
    data class Error(val error: Throwable?) : SpacePhotoState()
    data class Loading(val progress: Int?) : SpacePhotoState()
    data class Success(val data: SpacePhoto?) : SpacePhotoState()

}