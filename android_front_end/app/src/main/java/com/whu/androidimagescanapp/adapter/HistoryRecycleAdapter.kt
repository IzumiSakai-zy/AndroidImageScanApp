package com.whu.androidimagescanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.item.HistoryItem
import com.whu.androidimagescanapp.viewholder.HistoryItemViewHolder

class HistoryRecycleAdapter(private val itemList: List<HistoryItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HistoryItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_item_history, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? HistoryItemViewHolder)?.apply {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.resources, itemList[position].drawableId, null))
            resultText.text = itemList[position].result
            if (itemList[position].type == HistoryItem.OCR_TYPE) {
                resultType.text = "OCR"
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}