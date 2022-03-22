package com.whu.androidimagescanapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.adapter.HistoryRecycleAdapter
import com.whu.androidimagescanapp.item.HistoryItem

class HistoryFragment : Fragment() {

    companion object {
        const val TAT = "history_fragment"

        @JvmStatic
        fun newInstance() = HistoryFragment()
    }

    private var recycleView:RecyclerView? = null
    private lateinit var itemList:List<HistoryItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false).apply {
            recycleView = findViewById(R.id.history_recycle_view)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setItemList()
        recycleView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HistoryRecycleAdapter(itemList)
        }
    }

    private fun setItemList() {
        itemList = listOf(
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_1, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_2, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_3, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_4, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_5, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_6, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_7, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_8, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_9, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_10, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_11, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_12, requireContext().getString(R.string.main_page_predicted_result)),
            HistoryItem(HistoryItem.CLASSFICATION_TYPE, R.drawable.search_dog_item_13, requireContext().getString(R.string.main_page_predicted_result)),
        )
    }
}