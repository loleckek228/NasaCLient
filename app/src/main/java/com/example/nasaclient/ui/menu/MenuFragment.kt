package com.example.nasaclient.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nasaclient.R
import com.example.nasaclient.application.App
import com.example.nasaclient.mvp.presenter.MenuPresenter
import com.example.nasaclient.mvp.view.MenuView
import kotlinx.android.synthetic.main.earth_photos.*
import kotlinx.android.synthetic.main.mars_photos.*
import kotlinx.android.synthetic.main.mars_weather.*
import kotlinx.android.synthetic.main.space_photo.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenuFragment : MvpAppCompatFragment(), MenuView {
    private val presenter: MenuPresenter by moxyPresenter {
        MenuPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onMarsWeatherClicked()
        onEarthPhotosClicked()
        onSpacePhotoClicked()
        onMarsPhotosClicked()
    }

    private fun onMarsWeatherClicked() {
        menu_mars_weather.setOnClickListener {
            presenter.onMarsWeatherClicked()
        }
    }

    private fun onEarthPhotosClicked() {
        menu_earth_photos.setOnClickListener {
            presenter.onEarthPhotosClicked()
        }
    }

    private fun onSpacePhotoClicked() {
        menu_space_photo.setOnClickListener {
            presenter.onSpacePhotoClicked()
        }
    }

    private fun onMarsPhotosClicked() {
        menu_mars_photos.setOnClickListener {
            presenter.onMarsPhotoClicked()
        }
    }
}