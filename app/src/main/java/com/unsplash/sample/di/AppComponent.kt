package com.unsplash.sample.di

import com.unsplash.sample.Application
import com.unsplash.sample.di.modules.ActivityResolver
import com.unsplash.sample.di.modules.DataSourceResolver
import com.unsplash.sample.di.modules.NetworkResolver
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        NetworkResolver::class,
        ActivityResolver::class,
        DataSourceResolver::class
    )
)
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}