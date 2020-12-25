package com.example.nasaclient.mvp.view

import com.example.nasaclient.mvp.model.state.EarthPhotosState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface EarthPhotosView : MvpView {
    fun init()
    fun renderData(state: EarthPhotosState?)
}