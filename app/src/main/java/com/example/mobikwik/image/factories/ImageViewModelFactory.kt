package com.example.mobikwik.image.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobikwik.data.repository.ImageRepository
import com.example.mobikwik.image.ImageViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageViewModelFactory @Inject constructor(private val imageRepository: ImageRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageRepository) as T

    }

}