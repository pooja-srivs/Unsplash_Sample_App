package com.example.sample.data.remote.sources

import io.reactivex.Single

class ImageSource(val apiKey : String, val imageService : ImageService) {

    fun getImages(query : String): Single<UnsplashResponse> {
        return imageService.getImages(apiKey, query)
    }
}