package com.example.nasaclient.ui.marsphotos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaclient.R
import com.example.nasaclient.mvp.model.entity.marsphotos.MarsPhoto
import com.example.nasaclient.mvp.view.image.IImageLoader
import kotlinx.android.synthetic.main.fragment_mars_photos_recyclerview_item.view.*
import javax.inject.Inject

class MarsPhotosAdapter : RecyclerView.Adapter<MarsPhotosAdapter.ViewHolder>() {
    @Inject
    lateinit var loader: IImageLoader<ImageView>

    private var data: List<MarsPhoto> = arrayListOf()

    fun setData(data: List<MarsPhoto>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_mars_photos_recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MarsPhoto) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                with(itemView) {
                    fragment_mars_photos_recycler_view_camera_name_textview.text =
                        data.camera?.full_name

                    fragment_mars_photos_recycler_view_sol_textview.text =
                        String.format("Sol: %s", data.sol.toString())

                    fragment_mars_photos_recycler_view_earth_date_textview.text =
                        String.format("Earth date: %s", data.earth_date)

                    loader.loadImage(data.img_src, fragment_mars_photos_recycler_view_imageview)
                }
            }
        }
    }
}