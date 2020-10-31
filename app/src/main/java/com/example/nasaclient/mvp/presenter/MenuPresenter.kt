package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.view.MenuView
import com.example.nasaclient.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MenuPresenter : MvpPresenter<MenuView>() {
    @Inject
    lateinit var router: Router

    fun onMarsPhotoClicked() {
        router.navigateTo(Screens.MarsPhotosScreen())
    }

    fun onEarthPhotosClicked() {
        router.navigateTo(Screens.EarthPhotosScreen())
    }

    fun onSpacePhotoClicked() {
        router.navigateTo(Screens.SpacePhotoScreen())
    }
}