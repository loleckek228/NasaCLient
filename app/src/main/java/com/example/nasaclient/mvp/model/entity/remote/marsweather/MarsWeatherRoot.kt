package com.example.nasaclient.mvp.model.entity.remote.marsweather

import com.google.gson.annotations.Expose

data class MarsWeatherRoot(
    @Expose val sol: MarsWeatherSol?
)