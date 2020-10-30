package com.example.nasaclient.mvp.model.entity.remote.marsweather

import com.google.gson.annotations.Expose

data class MarsWeatherTemperature(
    @Expose val mx: Double?,
    @Expose val mn: Double?
)