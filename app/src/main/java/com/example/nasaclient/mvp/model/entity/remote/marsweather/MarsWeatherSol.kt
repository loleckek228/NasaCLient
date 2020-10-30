package com.example.nasaclient.mvp.model.entity.remote.marsweather

import com.google.gson.annotations.Expose

data class MarsWeatherSol(
    @Expose val Last_UTC: String?,
    @Expose val AT: MarsWeatherTemperature?
)