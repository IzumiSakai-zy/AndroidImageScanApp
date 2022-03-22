package com.whu.androidimagescanapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R

class HistoryItemViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val imageView = view.findViewById<ImageView>(R.id.history_item_image)
    val resultText = view.findViewById<TextView>(R.id.history_item_result_text)

    init {
        view.findViewById<ImageView>(R.id.history_see_more_point).setOnClickListener {
            Toast.makeText(it.context, it.context.getString(R.string.have_not_implement), Toast.LENGTH_SHORT).show()
        }
    }
}