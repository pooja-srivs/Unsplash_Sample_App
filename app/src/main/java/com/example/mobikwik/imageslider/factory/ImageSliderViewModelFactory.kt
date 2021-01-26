package com.example.mobikwik.imageslider.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobikwik.data.repository.ImageRepository
import com.example.mobikwik.imageslider.ImageSliderViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageSliderViewModelFactory @Inject constructor(private val imageRepository: ImageRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageSliderViewModel(imageRepository) as T

    }

}