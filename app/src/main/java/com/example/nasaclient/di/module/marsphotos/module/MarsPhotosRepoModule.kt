package com.example.nasaclient.di.module.marsphotos.module

import com.example.nasaclient.mvp.model.datasource.api.IMarsPhotosDataSource
import com.example.nasaclient.mvp.model.repo.MarsPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IMarsPhotosRepo
import dagger.Module
import dagger.Provides

@Module
open class MarsPhotosRepoModule {
    @Provides
    fun marsPhotosRepo(dataSource: IMarsPhotosDataSource): IMarsPhotosRepo =
        MarsPhotosRepo(dataSource)
}