package com.example.nasaclient.mvp.view

import com.example.nasaclient.mvp.model.state.SpacePhotoState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SpacePhotoView : MvpView {
    fun renderData(state: SpacePhotoState?)
}