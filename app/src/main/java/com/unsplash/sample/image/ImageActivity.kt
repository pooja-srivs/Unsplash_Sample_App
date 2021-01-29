package com.unsplash.sample.image

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.unsplash.sample.R
import com.unsplash.sample.image.adapter.ImageAdapter
import com.unsplash.sample.image.adapter.ImageListItem
import com.unsplash.sample.imageslider.ImageSliderActivity
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_image.*
import timber.log.Timber
import javax.inject.Inject


class ImageActivity : AppCompatActivity() {

    private lateinit var imageAdapter : ImageAdapter
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var viewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        viewModel.getImages()
                        .subscribe({
                            onImageResult(it)
                            progress.visibility = View.GONE
                        }, {
                            onErrorResult(it)
                            progress.visibility = View.GONE
                        })
                        .addDisposer(compositeDisposable)

        Timber.plant(Timber.DebugTree())

        val onImageItemClick = { position: Int ->
           val imageItem = imageAdapter.getItemAt(position)
            if (imageItem != null){
                startActivity(Intent(this@ImageActivity, ImageSliderActivity::class.java).also {
                    it.putExtra(ImageSliderActivity.IMG_CLICKED_POSITION, position)
                    it.putStringArrayListExtra(
                        ImageSliderActivity.UNSPLASH_IMG_KEY,
                        viewModel.getImageArray()
                    )
                })

            }else{
                Toast.makeText(
                    this@ImageActivity,
                    ImageSliderActivity.UNKNOWN_ERROR,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        list_movie.setLayoutManager(GridLayoutManager(this, 2))
        list_movie.adapter = ImageAdapter.newInstance(onImageItemClick)
            .also {
                imageAdapter = it
            }
    }

    fun onImageResult(items: List<ImageListItem>){
        if (items.isEmpty()){
            text_error.visibility = View.VISIBLE
            progress.visibility = View.GONE
            return
        }
        text_error.visibility = View.GONE
        imageAdapter.submitList(items)
    }

    fun onErrorResult(error: Throwable){
        Timber.e(error)
        text_error.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}

     fun Disposable.addDisposer(compositeDisposable: CompositeDisposable) {
        compositeDisposable.add(this)
    }
