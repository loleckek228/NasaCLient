package com.example.nasaclient.mvp.view

import com.example.nasaclient.mvp.model.state.MarsWeatherState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MarsWeatherView : MvpView {
    fun init()
    fun renderData(state: MarsWeatherState?)
}