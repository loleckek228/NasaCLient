package com.example.nasaclient.ui.marsweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nasaclient.R
import moxy.MvpAppCompatFragment

class MarsWeatherFragment : MvpAppCompatFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars_weather, container, false)
    }
}