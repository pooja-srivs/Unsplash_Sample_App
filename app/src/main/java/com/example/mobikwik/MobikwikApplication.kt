package com.example.mobikwik

import com.example.mobikwik.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MobikwikApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder()
        .application(this)
        .build()
}