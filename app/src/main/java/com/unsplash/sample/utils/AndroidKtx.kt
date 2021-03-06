package com.unsplash.sample.utils

import android.widget.ImageView
import com.unsplash.sample.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url : String){
    //add placeholder
    Picasso.get().load(url).placeholder(R.drawable.placeholder_image).into(this)
}

fun ImageView.cancelImageLoading(){
    Picasso.get().cancelRequest(this)
}