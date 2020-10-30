package com.example.nasaclient.ui.marsweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasaclient.R
import com.example.nasaclient.application.App
import com.example.nasaclient.di.module.marsweather.MarsWeatherSubcomponent
import com.example.nasaclient.mvp.model.entity.remote.marsweather.MarsWeatherRoot
import com.example.nasaclient.mvp.model.state.MarsWeatherState
import com.example.nasaclient.mvp.presenter.MarsWeatherPresenter
import com.example.nasaclient.mvp.view.MarsWeatherView
import com.example.nasaclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_mars_weather.*
import kotlinx.android.synthetic.main.loading_layout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MarsWeatherFragment : MvpAppCompatFragment(), BackButtonListener, MarsWeatherView {
    lateinit var marsWeatherSubcomponent: MarsWeatherSubcomponent

    private lateinit var dateTextView: TextView
    private lateinit var maxTempreatureTextView: TextView
    private lateinit var minTemperature: TextView
    private lateinit var solTextView: TextView

    private val marsWeatherAdapter: MarsWeatherAdapter by lazy {
        MarsWeatherAdapter()
    }

    private val presenter: MarsWeatherPresenter by moxyPresenter {
        MarsWeatherPresenter().apply {
            marsWeatherSubcomponent = App.instance.initMarsWeatherSubcomponent()
            marsWeatherSubcomponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars_weather, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        App.instance.releaseMarsWeatherSubcomponent()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun init() {
        with(fragment_mars_weather_recyclerview) {
            layoutManager = GridLayoutManager(context, 5)
            adapter = marsWeatherAdapter
        }
    }

    override fun renderData(state: MarsWeatherState?) {
        when (state) {
            is MarsWeatherState.Error -> {
                showViewWorking()

                Toast.makeText(context, state.error!!.message, Toast.LENGTH_LONG).show()
            }

            is MarsWeatherState.Loading -> {
                showViewLoading()

                state.progress?.let {
                    progress_bar_round.visibility = View.GONE
                }?.let {
                    progress_bar_round.visibility = View.VISIBLE
                }
            }

            is MarsWeatherState.Success -> {
                showViewWorking()

                state.data?.let {
//                    setDataToAdapter(state.data)
                }
            }
        }
    }

    private fun setDataToAdapter(data: List<MarsWeatherRoot>?) {
        marsWeatherAdapter.setData(data)
    }

    private fun showViewLoading() {
        loading_frame_layout.visibility = View.VISIBLE
        fragment_mars_weather_layout.visibility = View.GONE
    }

    private fun showViewWorking() {
        loading_frame_layout.visibility = View.GONE
        fragment_mars_weather_layout.visibility = View.VISIBLE
    }
}