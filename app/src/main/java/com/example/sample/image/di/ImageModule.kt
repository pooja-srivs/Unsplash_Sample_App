package com.example.sample.image.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.sample.data.repository.ImageRepository
import com.example.sample.image.ImageActivity
import com.example.sample.image.ImageViewModel
import com.example.sample.image.factories.ImageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ImageModule{

    @Provides
    fun provideImageViewModelFactory(imageRepository : ImageRepository) = ImageViewModelFactory(imageRepository)

    @Provides
    fun provideImageViewModel(factory : ImageViewModelFactory, activity : ImageActivity) = ViewModelProviders
        .of(activity as AppCompatActivity, factory)
        .get(ImageViewModel::class.java)

}