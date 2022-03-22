package com.whu.androidimagescanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.viewholder.SearchItemViewHolder
import com.whu.androidimagescanapp.viewholder.SearchSeeMoreItemViewHolder

class SearchListAdapter(private val imageResourceIdList:List<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_IMAGE = 0
        private const val ITEM_SEE_MORE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == ITEM_SEE_MORE) {
            SearchSeeMoreItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recycle_item_see_more_search, parent, false)
            )
        } else {
            SearchItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recycle_item_search, parent, false)
            )
        }

    override fun getItemCount(): Int = imageResourceIdList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? SearchItemViewHolder)?.imageItemView?.setImageResource(imageResourceIdList[position])
        (holder as? SearchSeeMoreItemViewHolder)?.imageItemView?.setImageResource(imageResourceIdList[position])
    }

    override fun getItemViewType(position: Int): Int =
        //没有实现'查看更多'
        if (imageResourceIdList[position] == -1) {
            ITEM_SEE_MORE
        } else {
            ITEM_IMAGE
        }
}