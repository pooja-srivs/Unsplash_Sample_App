package com.example.sample.imageslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sample.R
import com.example.sample.imageslider.adapter.ImageSliderAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_image_slider.*
import javax.inject.Inject

class ImageSliderActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ImageSliderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)

        val imgArr =
            intent.extras?.getStringArrayList(ImageSliderActivity.UNSPLASH_IMG_KEY) as ArrayList<String>
        val img_clicked_pos = intent.extras?.getInt(ImageSliderActivity.IMG_CLICKED_POSITION) ?: 0
        imageSliderImplementation(imgArr, img_clicked_pos)

        setListener()

    }

    private fun setListener() {
        img_cross.setOnClickListener {
            finish()
        }

        img_swipe_left.setOnClickListener {
            if (viewpager.getCurrentItem() != 0)
                viewpager.setCurrentItem(viewpager.getCurrentItem() - 1);
        }

        img_swipe_right.setOnClickListener{
            if (viewpager.getCurrentItem() < viewpager.getAdapter()?.getCount() ?: 0)
                viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
        }
    }
    private fun imageSliderImplementation(imgArr: ArrayList<String>, img_clicked_pos: Int) {

        val adapter = ImageSliderAdapter(this, imgArr)
        viewpager.adapter = adapter
        viewpager.setCurrentItem(img_clicked_pos)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object{
        const val IMG_CLICKED_POSITION = "img_clicked_pos"
        const val UNSPLASH_IMG_KEY = "unsplash_img_key"
        const val UNKNOWN_ERROR = "Something went wrong !"
    }
}
