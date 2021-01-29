package com.unsplash.sample.data.repository

import com.unsplash.sample.data.remote.sources.*
import io.reactivex.Single

class ImageRepository(private val imageSource : ImageSource) {

    fun getImages(): Single<UnsplashResponse> {
       return imageSource.getImages("30")
    }
}