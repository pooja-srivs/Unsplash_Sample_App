package com.unsplash.sample.di.modules

import com.unsplash.sample.data.remote.config.ApiManager
import com.unsplash.sample.data.remote.sources.ImageSource
import com.unsplash.sample.data.repository.ImageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceResolver {


    @Singleton
    @Provides
    fun provideImageDataSource(@Named("client_id")
                                   client_id : String, apiManager : ApiManager) : ImageSource = ImageSource(client_id, apiManager.imageService)

    @Singleton
    @Provides
    fun provideImageRepository(imageSource: ImageSource) : ImageRepository = ImageRepository(imageSource)

}