package com.example.nasaclient.ui.earthphotos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaclient.R
import com.example.nasaclient.mvp.model.entity.EarthPhoto
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.mvp.view.image.IImageLoader
import com.example.nasaclient.utils.convertUrl
import kotlinx.android.synthetic.main.fragment_earth_photos_recyclerview_item.view.*
import javax.inject.Inject

class EarthPhotosAdapter : RecyclerView.Adapter<EarthPhotosAdapter.ViewHolder>() {
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    private var data: List<EarthPhoto?> = arrayListOf()

    fun setData(data: List<EarthPhoto?>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_earth_photos_recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.get(position)!!)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: EarthPhoto) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                with(itemView) {
                    fragment_earth_photos_recyclerview_item_caption_textview.text = data.caption
                    fragment_earth_photos_recyclerview_item_date_textview.text = data.date

                    val url = convertUrl(data.date, data.image)
                    imageLoader.loadImage(url, fragment_earth_photos_recyclerview_item_imageview)
                }
            }
        }
    }
}