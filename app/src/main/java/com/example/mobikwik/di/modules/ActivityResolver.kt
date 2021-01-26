package com.example.mobikwik.di.modules

import com.example.mobikwik.imageslider.ImageSliderActivity
import com.example.mobikwik.imageslider.di.ImageSliderModule
import com.example.mobikwik.image.ImageActivity
import com.example.mobikwik.image.di.ImageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(ImageModule::class))
    abstract fun provideSearchActivity(): ImageActivity

    @ContributesAndroidInjector(modules = arrayOf(ImageSliderModule::class))
    abstract fun provideDetailActivity(): ImageSliderActivity
}