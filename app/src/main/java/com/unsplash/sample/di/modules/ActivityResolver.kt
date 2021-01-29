package com.unsplash.sample.di.modules

import com.unsplash.sample.imageslider.ImageSliderActivity
import com.unsplash.sample.imageslider.di.ImageSliderModule
import com.unsplash.sample.image.ImageActivity
import com.unsplash.sample.image.di.ImageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(ImageModule::class))
    abstract fun provideSearchActivity(): ImageActivity

    @ContributesAndroidInjector(modules = arrayOf(ImageSliderModule::class))
    abstract fun provideDetailActivity(): ImageSliderActivity
}