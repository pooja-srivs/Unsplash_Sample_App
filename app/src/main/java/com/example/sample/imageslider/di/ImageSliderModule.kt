package com.example.sample.imageslider.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.sample.data.repository.ImageRepository
import com.example.sample.imageslider.ImageSliderActivity
import com.example.sample.imageslider.ImageSliderViewModel
import com.example.sample.imageslider.factory.ImageSliderViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ImageSliderModule{

    @Provides
    fun provideImageSliderViewModelFactory(imageRepository : ImageRepository) = ImageSliderViewModelFactory(imageRepository)

    @Provides
    fun provideImageSliderViewModel(factory : ImageSliderViewModelFactory, activity : ImageSliderActivity) = ViewModelProviders
        .of(activity as AppCompatActivity, factory)
        .get(ImageSliderViewModel::class.java)

}