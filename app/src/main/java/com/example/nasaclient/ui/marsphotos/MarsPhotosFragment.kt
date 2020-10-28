package com.example.nasaclient.ui.marsphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaclient.R
import com.example.nasaclient.application.App
import com.example.nasaclient.di.module.marsphotos.MarsPhotosSubcomponent
import com.example.nasaclient.mvp.model.entity.marsphotos.MarsPhoto
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import com.example.nasaclient.mvp.presenter.MarsPhotosPresenter
import com.example.nasaclient.mvp.view.MarsPhotosView
import com.example.nasaclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_mars_photos.*
import kotlinx.android.synthetic.main.loading_layout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MarsPhotosFragment : MvpAppCompatFragment(), BackButtonListener, MarsPhotosView {
    private lateinit var marsPhotosSubcomponent: MarsPhotosSubcomponent

    private val presenter: MarsPhotosPresenter by moxyPresenter {
        MarsPhotosPresenter().apply {
            marsPhotosSubcomponent = App.instance.initMarsPhotosSubcomponent()
            marsPhotosSubcomponent.inject(this)
        }
    }
    private val marsPhotosadapter: MarsPhotosAdapter by lazy {
        MarsPhotosAdapter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars_photos, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        App.instance.releaseMarsPhotosSubcomponent()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun init() {
        with(fragment_mars_photos_recycler_view) {
            layoutManager = LinearLayoutManager(context.applicationContext)
            adapter = marsPhotosadapter
        }
    }

    override fun renderData(state: MarsPhotosState?) {
        when (state) {
            is MarsPhotosState.Error -> {
                showViewWorking()

                Toast.makeText(context, state.error!!.message, Toast.LENGTH_LONG).show()
            }

            is MarsPhotosState.Loading -> {
                showViewLoading()

                state.progress?.let {
                    progress_bar_round.visibility = View.GONE
                }?.let {
                    progress_bar_round.visibility = View.VISIBLE
                }
            }

            is MarsPhotosState.Success -> {
                showViewWorking()

                state.data?.photos?.let {
                    setDataToAdapter(it)
                }
            }
        }
    }

    private fun setDataToAdapter(data: List<MarsPhoto>) {
        marsPhotosadapter.setData(data)
    }

    private fun showViewLoading() {
        loading_frame_layout.visibility = View.VISIBLE
    }

    private fun showViewWorking() {
        loading_frame_layout.visibility = View.GONE
    }
}