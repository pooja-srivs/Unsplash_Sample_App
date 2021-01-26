package com.example.mobikwik.image.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobikwik.R
import com.example.mobikwik.utils.cancelImageLoading
import com.example.mobikwik.utils.loadImage
import kotlinx.android.synthetic.main.image_item.view.*
import java.io.Serializable

class ImageAdapter private constructor(
    private val diffUtil: DiffUtil.ItemCallback<ImageListItem>,
    private val onItemClick: (Int) -> Unit
) : ListAdapter<ImageListItem, ImageItemVH>(diffUtil){

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageListItem>() {

            override fun areItemsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean =
                oldItem.imageId == newItem.imageId

            override fun areContentsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean =
                oldItem == newItem

        }

        fun newInstance(onItemClick : (Int) -> Unit) = ImageAdapter(
            DIFF_CALLBACK, onItemClick
        )
    }

    fun getItemAt(position: Int): ImageListItem? {
        return getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ImageItemVH(view)
    }

    override fun onBindViewHolder(holder: ImageItemVH, position: Int) {
       holder.bind(requireNotNull(getItemAt(position)), onItemClick)
    }

    override fun onViewAttachedToWindow(holder: ImageItemVH) {
        super.onViewAttachedToWindow(holder)
        holder.loadImagePoster()
    }

    override fun onViewDetachedFromWindow(holder: ImageItemVH) {
        super.onViewDetachedFromWindow(holder)
        holder.cancelLoading()
    }

}

class ImageItemVH(view : View) : RecyclerView.ViewHolder(view){

    var imageListItem : ImageListItem? = null
    val image_random = view.image_random

    fun bind(
        imageListItem: ImageListItem,
        onItemClick: (Int) -> Unit
    ){
        this.imageListItem = imageListItem
        image_random.loadImage(imageListItem.imageUrl)

        itemView.setOnClickListener {
            onItemClick.invoke(adapterPosition)
        }
    }

    fun cancelLoading(){
        image_random.cancelImageLoading()
    }

    fun loadImagePoster(){
        image_random.loadImage(imageListItem?.imageUrl?:"")
    }

}

data class ImageListItem(val imageUrl: String, val imageId : String)