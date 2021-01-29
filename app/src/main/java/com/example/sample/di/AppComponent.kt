package com.example.sample.di

import com.example.sample.MobikwikApplication
import com.example.sample.di.modules.ActivityResolver
import com.example.sample.di.modules.DataSourceResolver
import com.example.sample.di.modules.NetworkResolver
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
interface AppComponent : AndroidInjector<MobikwikApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MobikwikApplication): Builder

        fun build(): AppComponent
    }
}