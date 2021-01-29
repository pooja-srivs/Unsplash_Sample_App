package com.unsplash.sample.data.remote.sources

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET("/photos?")
    fun getImages(@Query("client_id") apiKey : String, @Query("count") query : String) : Single<UnsplashResponse>

}