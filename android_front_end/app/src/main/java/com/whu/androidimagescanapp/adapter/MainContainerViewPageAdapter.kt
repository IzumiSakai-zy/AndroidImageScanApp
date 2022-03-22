package com.whu.androidimagescanapp.adapter

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.fragment.HistoryFragment
import com.whu.androidimagescanapp.fragment.HomePageFragment
import com.whu.androidimagescanapp.fragment.MySelfFragment
import com.whu.androidimagescanapp.fragment.SearchFragment

class MainContainerViewPageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    companion object {
        const val FRAGMENT_TOTAL_COUNT = 4

        const val HOME_PAGE_INDEX = 0
        const val SEARCH_PAGE_INDEX = 1
        const val HISTORY_PAGE_INDEX = 2
        const val MY_SELF_PAGE_INDEX = 3
    }

    private val homePageFragment:HomePageFragment by lazy { HomePageFragment.newInstance() }
    private val searchFragment:SearchFragment by lazy { SearchFragment.newInstance() }
    private val historyFragment:HistoryFragment by lazy { HistoryFragment.newInstance() }
    private val mySelfFragment:MySelfFragment by lazy { MySelfFragment.newInstance() }

    //暴露Homepage的ScannedImage给拍摄后显示图片使用
    fun getHomePageFragmentScannedView():ImageView? {
        return homePageFragment.view?.findViewById(R.id.home_page_scanned_image)
    }

    override fun createFragment(position: Int): Fragment =
        when(position) {
            HOME_PAGE_INDEX -> homePageFragment
            SEARCH_PAGE_INDEX -> searchFragment
            HISTORY_PAGE_INDEX -> historyFragment
            else -> mySelfFragment
        }

    override fun getItemCount(): Int = FRAGMENT_TOTAL_COUNT
}