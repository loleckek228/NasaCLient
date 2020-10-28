package com.example.nasaclient.di.module

import com.example.nasaclient.application.App
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App = app

    @Provides
    fun mainThreadScheduler() = AndroidSchedulers.mainThread()
}