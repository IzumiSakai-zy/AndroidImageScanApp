package com.whu.androidimagescanapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.adapter.ImageRecycleAdapter

class SearchFragment : Fragment() {

    companion object {
        const val TAG = "search_fragment"
        @JvmStatic
        fun newInstance() = SearchFragment()
    }

    private var recyclerView:RecyclerView? = null
    private lateinit var imageResourceIndexList:List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false).let {
            recyclerView = it.findViewById(R.id.search_recycle_view)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResourceIndexList()

        recyclerView?.apply {
            adapter = ImageRecycleAdapter(imageResourceIndexList)
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun setResourceIndexList() {
        imageResourceIndexList = mutableListOf(
            R.drawable.search_dog_item_1,
            R.drawable.search_dog_item_2,
            R.drawable.search_dog_item_3,
            R.drawable.search_dog_item_4,
            R.drawable.search_dog_item_5,
            R.drawable.search_dog_item_6,
            R.drawable.search_dog_item_7,
            R.drawable.search_dog_item_8,
            R.drawable.search_dog_item_9,
            R.drawable.search_dog_item_10,
            R.drawable.search_dog_item_11,
            R.drawable.search_dog_item_12,
            R.drawable.search_dog_item_13,
            R.drawable.search_dog_item_14,
            R.drawable.search_dog_item_15,
            R.drawable.search_dog_item_5
        )
    }
}