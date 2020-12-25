package com.example.nasaclient.di.module

import androidx.room.Room
import com.example.nasaclient.application.App
import com.example.nasaclient.mvp.model.datasource.local.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun database(app: App): Database =
        Room.databaseBuilder(
            app.applicationContext,
            Database::class.java,
            Database.DB_NAME
        ).build()
}