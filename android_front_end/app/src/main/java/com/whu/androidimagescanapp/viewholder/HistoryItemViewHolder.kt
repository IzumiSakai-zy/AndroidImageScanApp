package com.whu.androidimagescanapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.utils.CommonUtils

class HistoryItemViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val imageView:ImageView = view.findViewById(R.id.history_item_image)
    val resultText:TextView = view.findViewById(R.id.history_item_result_text)
    private val seeMorePoint:ImageView = view.findViewById(R.id.history_see_more_point)

    init {
        imageView.setOnClickListener {
            CommonUtils.previewImage(it.context as? FragmentActivity, it as? ImageView)
        }
        seeMorePoint.setOnClickListener {
            Toast.makeText(it.context, it.context.getString(R.string.have_not_implement), Toast.LENGTH_SHORT).show()
        }
    }
}