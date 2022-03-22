package com.whu.androidimagescanapp.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R

class SeeMoreImageViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val imageItemView:ImageView = view.findViewById(R.id.search_recycle_see_more_item)
}