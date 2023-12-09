package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val WaifuList: List<Waifu>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    data class Waifu(var titleimage : Int, var heading : String)
    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

        val titleimage : ShapeableImageView = itemview.findViewById(R.id.title_image)
        val tvHeading : TextView = itemview.findViewById(R.id.tvHeading)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_list,
            parent, false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = WaifuList[position]
        holder.titleimage.setImageResource(currentItem.titleimage)
        holder.tvHeading.text = currentItem.heading
    }


    override fun getItemCount(): Int {
        return WaifuList.size
    }


}