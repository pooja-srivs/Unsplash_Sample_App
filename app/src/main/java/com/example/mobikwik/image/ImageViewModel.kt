package com.example.mobikwik.image

import androidx.lifecycle.ViewModel
import com.example.mobikwik.data.repository.ImageRepository
import com.example.mobikwik.image.adapter.ImageListItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageViewModel(val imageRespository : ImageRepository) : ViewModel() {

    private var imgArr : MutableList<String> = mutableListOf()

    fun getImages(): Observable<List<ImageListItem>> {

       return imageRespository.getImages()
            .toObservable()
            .map { response ->
               response.map {
                   imgArr.add(it.urls.regular)
                   ImageListItem(it.urls.regular, it.id)
               }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getImageArray(): ArrayList<String> {
        return imgArr as ArrayList<String>
    }

}