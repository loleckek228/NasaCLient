package com.example.nasaclient.ui.marsweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaclient.R
import com.example.nasaclient.mvp.model.entity.remote.marsweather.MarsWeatherRoot
import kotlinx.android.synthetic.main.fragment_mars_weather_recyclerview_item.view.*

class MarsWeatherAdapter : RecyclerView.Adapter<MarsWeatherAdapter.ViewHolder>() {
    private var data: List<MarsWeatherRoot> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_mars_weather_recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size

    fun setData(data: List<MarsWeatherRoot>?) {
        this.data = data!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MarsWeatherRoot) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                with(itemView) {
                    fragment_mars_weather_recyclerview_item_sol_textview.text = data.sol.toString()

//                    fragment_mars_weather_recyclerview_item_date_textview.text =
//                        data.sol?.Last_UTC
//
//                    fragment_mars_weather_recyclerview_item_high_textview.text =
//                        data.sol?.AT?.mx.toString()
//
//                    fragment_mars_weather_recyclerview_item_low_textview.text =
//                        data.sol?.AT?.mn.toString()
                }
            }
        }
    }
}
