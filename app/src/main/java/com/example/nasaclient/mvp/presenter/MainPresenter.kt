package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.view.MainView
import com.example.nasaclient.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(Screens.MenuScreen())
    }

    fun backClicked() {
        router.exit()
    }
}