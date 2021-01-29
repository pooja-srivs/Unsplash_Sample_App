package com.example.sample.data.repository

import com.example.sample.data.remote.sources.*
import io.reactivex.Single

class ImageRepository(private val imageSource : ImageSource) {

    fun getImages(): Single<UnsplashResponse> {
       return imageSource.getImages("30")
    }
}