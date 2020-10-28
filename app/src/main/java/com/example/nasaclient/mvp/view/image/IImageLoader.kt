package com.example.nasaclient.mvp.view.image

interface IImageLoader<T> {
    fun loadImage(url: String?, container: T)
}