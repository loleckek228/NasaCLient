package com.example.nasaclient.di.module.earthphotos.module

import com.example.nasaclient.mvp.model.datasource.api.IEarthPhotosDataSource
import com.example.nasaclient.mvp.model.repo.EarthPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IEarthPhotosRepo
import dagger.Module
import dagger.Provides

@Module
class EarthPhotosRepoModule {
    @Provides
    fun earthPhotoRepo(dataSource: IEarthPhotosDataSource): IEarthPhotosRepo =
        EarthPhotosRepo(dataSource)
}