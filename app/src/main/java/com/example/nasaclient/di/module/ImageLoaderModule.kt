package com.example.nasaclient.di.module

import android.widget.ImageView
import com.example.nasaclient.mvp.view.image.GlideImageLoader
import com.example.nasaclient.mvp.view.image.IImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageLoaderModule {
    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> =
        GlideImageLoader()
}