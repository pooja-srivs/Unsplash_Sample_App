package com.example.mobikwik.data.remote.config

import com.example.mobikwik.data.remote.sources.ImageService
import retrofit2.Retrofit

class ApiManager(private val retrofit : Retrofit) {

    val imageService : ImageService by lazy {
        retrofit.create(ImageService::class.java)
    }

}