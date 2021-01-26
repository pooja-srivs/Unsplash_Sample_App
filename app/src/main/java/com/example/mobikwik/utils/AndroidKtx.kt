package com.example.mobikwik.utils

import android.widget.ImageView
import com.example.mobikwik.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url : String){
    //add placeholder
    Picasso.get().load(url).placeholder(R.drawable.placeholder_image).into(this)
}

fun ImageView.cancelImageLoading(){
    Picasso.get().cancelRequest(this)
}