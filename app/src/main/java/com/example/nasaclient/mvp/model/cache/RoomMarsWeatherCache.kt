package com.example.nasaclient.mvp.model.cache

import com.example.nasaclient.mvp.model.cache.icache.IRoomMarsWeatherCache
import com.example.nasaclient.mvp.model.datasource.local.Database

class RoomMarsWeatherCache(val database: Database) : IRoomMarsWeatherCache {
}