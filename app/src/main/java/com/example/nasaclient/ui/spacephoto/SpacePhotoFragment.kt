package com.example.nasaclient.ui.spacephoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.nasaclient.R
import com.example.nasaclient.application.App
import com.example.nasaclient.di.module.spacephoto.SpacePhotoSubcomponent
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.mvp.presenter.SpacePhotoPresenter
import com.example.nasaclient.mvp.view.SpacePhotoView
import com.example.nasaclient.mvp.view.image.IImageLoader
import com.example.nasaclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_space_photo.*
import kotlinx.android.synthetic.main.loading_layout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class SpacePhotoFragment : MvpAppCompatFragment(), BackButtonListener, SpacePhotoView {
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    private lateinit var dateTextView: TextView
    private lateinit var explanationTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var spacePhotoSubcomponent: SpacePhotoSubcomponent
    private lateinit var titleTextView: TextView

    private val presenter: SpacePhotoPresenter by moxyPresenter {
        SpacePhotoPresenter().apply {
            spacePhotoSubcomponent = App.instance.initSpacePhotoSubcomponent()
            spacePhotoSubcomponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_space_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.instance.appComponent.inject(this)

        dateTextView = fragment_space_photo_date_text_view
        explanationTextView = fragment_space_photo_explanation_text_view
        imageView = fragment_space_photo_imageview
        titleTextView = fragment_space_photo_title_text_view
    }

    override fun onDestroy() {
        super.onDestroy()

        App.instance.releaseSpacePhotoSubcomponent()
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun renderData(state: SpacePhotoState?) {
        when (state) {
            is SpacePhotoState.Error -> {
                showViewWorking()

                Toast.makeText(context, state.error!!.message, Toast.LENGTH_LONG).show()
            }

            is SpacePhotoState.Loading -> {
                showViewLoading()

                state.progress?.let {
                    progress_bar_round.visibility = View.GONE
                }?.let {
                    progress_bar_round.visibility = View.VISIBLE
                }
            }

            is SpacePhotoState.Success -> {
                showViewWorking()
                state.data?.let {
                    val date = state.data.date
                    val explanation = state.data.explanation
                    val title = state.data.title
                    val url = state.data.hdurl

                    imageLoader.loadImage(url, imageView)
                    dateTextView.text = date
                    explanationTextView.text = explanation
                    titleTextView.text = title
                }
            }
        }
    }

    private fun showViewLoading() {
        loading_frame_layout.visibility = View.VISIBLE
    }

    private fun showViewWorking() {
        loading_frame_layout.visibility = View.GONE
    }
}