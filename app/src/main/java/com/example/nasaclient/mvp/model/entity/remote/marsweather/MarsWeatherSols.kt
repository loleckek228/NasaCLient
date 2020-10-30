package com.example.nasaclient.mvp.model.entity.remote.marsweather

import com.google.gson.annotations.Expose

data class MarsWeatherSols(
    @Expose val sol_keys: List<String>
)