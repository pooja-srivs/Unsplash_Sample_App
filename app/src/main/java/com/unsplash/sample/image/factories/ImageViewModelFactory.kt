package com.unsplash.sample.image.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unsplash.sample.data.repository.ImageRepository
import com.unsplash.sample.image.ImageViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageViewModelFactory @Inject constructor(private val imageRepository: ImageRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageRepository) as T

    }

}