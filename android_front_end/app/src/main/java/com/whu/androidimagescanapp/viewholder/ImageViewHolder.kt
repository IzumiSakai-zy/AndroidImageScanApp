package com.whu.androidimagescanapp.viewholder

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.utils.CommonUtils

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageItemView: ImageView = view.findViewById(R.id.search_recycle_item)

    init {
        imageItemView.setOnClickListener {
            CommonUtils.previewImage(it.context as? FragmentActivity, it as? ImageView)
        }
    }
}