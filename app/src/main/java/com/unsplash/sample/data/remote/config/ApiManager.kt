package com.unsplash.sample.data.remote.config

import com.unsplash.sample.data.remote.sources.ImageService
import retrofit2.Retrofit

class ApiManager(private val retrofit : Retrofit) {

    val imageService : ImageService by lazy {
        retrofit.create(ImageService::class.java)
    }

}