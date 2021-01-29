package com.example.sample.di.modules

import com.example.sample.imageslider.ImageSliderActivity
import com.example.sample.imageslider.di.ImageSliderModule
import com.example.sample.image.ImageActivity
import com.example.sample.image.di.ImageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(ImageModule::class))
    abstract fun provideSearchActivity(): ImageActivity

    @ContributesAndroidInjector(modules = arrayOf(ImageSliderModule::class))
    abstract fun provideDetailActivity(): ImageSliderActivity
}