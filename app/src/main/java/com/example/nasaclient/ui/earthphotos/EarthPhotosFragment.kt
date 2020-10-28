package com.example.nasaclient.ui.earthphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaclient.R
import com.example.nasaclient.application.App
import com.example.nasaclient.di.module.earthphotos.EarthPhotosSubcomponent
import com.example.nasaclient.mvp.model.entity.EarthPhoto
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.mvp.presenter.EarthPhotosPresenter
import com.example.nasaclient.mvp.view.EarthPhotosView
import com.example.nasaclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_earth_photos.*
import kotlinx.android.synthetic.main.loading_layout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EarthPhotosFragment : MvpAppCompatFragment(), BackButtonListener, EarthPhotosView {
    private lateinit var earthPhotosSubcomponent: EarthPhotosSubcomponent

    private val presenter: EarthPhotosPresenter by moxyPresenter {
        EarthPhotosPresenter().apply {
            earthPhotosSubcomponent = App.instance.initEarthPhotosSubcomponent()
            earthPhotosSubcomponent.inject(this)
        }
    }

    private val earthPhotosAdapter: EarthPhotosAdapter by lazy {
        EarthPhotosAdapter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_earth_photos, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        App.instance.releaseEarthPhotosSubcomponent()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun init() {
        with(fragment_earth_photos_recycler_view) {
            layoutManager = LinearLayoutManager(context)
            adapter = earthPhotosAdapter
        }
    }

    override fun renderData(state: EarthPhotosState?) {
        when (state) {
            is EarthPhotosState.Error -> {
                showViewWorking()

                Toast.makeText(context, state.error!!.message, Toast.LENGTH_LONG).show()
            }

            is EarthPhotosState.Loading -> {
                showViewLoading()

                state.progress?.let {
                    progress_bar_round.visibility = View.GONE
                }?.let {
                    progress_bar_round.visibility = View.VISIBLE
                }
            }

            is EarthPhotosState.Success -> {
                showViewWorking()

                state.data.let {
                    setDataToAdapter(state.data)
                }

            }
        }
    }

    private fun setDataToAdapter(data: List<EarthPhoto?>) {
        earthPhotosAdapter.setData(data)
    }

    private fun showViewLoading() {
        loading_frame_layout.visibility = View.VISIBLE
    }

    private fun showViewWorking() {
        loading_frame_layout.visibility = View.GONE
    }
}