package com.whu.androidimagescanapp.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R

class ImageViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val imageItemView = view.findViewById<ImageView>(R.id.search_recycle_item)
}