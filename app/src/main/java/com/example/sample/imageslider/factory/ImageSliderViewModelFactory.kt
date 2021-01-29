package com.example.sample.imageslider.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sample.data.repository.ImageRepository
import com.example.sample.imageslider.ImageSliderViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageSliderViewModelFactory @Inject constructor(private val imageRepository: ImageRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageSliderViewModel(imageRepository) as T

    }

}