package com.example.nasaclient.mvp.view

import com.example.nasaclient.mvp.model.state.MarsPhotosState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MarsPhotosView : MvpView {
    fun init()
    fun renderData(state: MarsPhotosState?)
}