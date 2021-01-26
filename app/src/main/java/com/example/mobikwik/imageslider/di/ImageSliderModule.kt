package com.example.mobikwik.imageslider.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.mobikwik.data.repository.ImageRepository
import com.example.mobikwik.imageslider.ImageSliderActivity
import com.example.mobikwik.imageslider.ImageSliderViewModel
import com.example.mobikwik.imageslider.factory.ImageSliderViewModelFactory
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