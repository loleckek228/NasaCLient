package com.example.nasaclient.di

import com.example.nasaclient.di.module.ApiModule
import com.example.nasaclient.di.module.AppModule
import com.example.nasaclient.di.module.CiceroneModule
import com.example.nasaclient.di.module.ImageLoaderModule
import com.example.nasaclient.di.module.earthphotos.EarthPhotosSubcomponent
import com.example.nasaclient.di.module.marsphotos.MarsPhotosSubcomponent
import com.example.nasaclient.di.module.spacephoto.SpacePhotoSubcomponent
import com.example.nasaclient.mvp.presenter.MainPresenter
import com.example.nasaclient.mvp.presenter.MenuPresenter
import com.example.nasaclient.ui.earthphotos.EarthPhotosAdapter
import com.example.nasaclient.ui.main.MainActivity
import com.example.nasaclient.ui.marsphotos.MarsPhotosAdapter
import com.example.nasaclient.ui.spacephoto.SpacePhotoFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        ImageLoaderModule::class
    ]
)

interface AppComponent {
    fun spacePhotoSubcomponent(): SpacePhotoSubcomponent
    fun marsPhotosSubcomponent(): MarsPhotosSubcomponent
    fun earthPhotosSubcomponent(): EarthPhotosSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(menuPresenter: MenuPresenter)
    fun inject(spacePhotoFragment: SpacePhotoFragment)
    fun inject(marsPhotosAdapter: MarsPhotosAdapter)
    fun inject(earthPhotosAdapter: EarthPhotosAdapter)
}