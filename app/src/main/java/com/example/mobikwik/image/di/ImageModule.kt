package com.example.mobikwik.image.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.mobikwik.data.repository.ImageRepository
import com.example.mobikwik.image.ImageActivity
import com.example.mobikwik.image.ImageViewModel
import com.example.mobikwik.image.factories.ImageViewModelFactory
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