package com.example.nasaclient.mvp.view.image

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.nasaclient.application.App

class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadImage(url: String?, container: ImageView) {
        val circularProgressDrawable = getProgressDrawable()

        Glide.with(container.context).asBitmap()
            .load(url)
            .placeholder(circularProgressDrawable)
            .into(container)
    }

    private fun getProgressDrawable(): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(App.instance.applicationContext)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        return circularProgressDrawable
    }
}