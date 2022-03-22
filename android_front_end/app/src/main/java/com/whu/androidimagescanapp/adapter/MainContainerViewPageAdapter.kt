package com.whu.androidimagescanapp.adapter

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.ui.HomePageFragment
import com.whu.androidimagescanapp.ui.MySelfFragment
import com.whu.androidimagescanapp.ui.SearchFragment

class MainContainerViewPageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    companion object {
        const val FRAGMENT_TOTAL_COUNT = 3

        const val SEARCH_PAGE_INDEX = 0
        const val HOME_PAGE_INDEX = 1
        const val MY_SELF_PAGE_INDEX = 2
    }

    private val searchFragment:SearchFragment by lazy { SearchFragment.newInstance() }
    private val homePageFragment:HomePageFragment by lazy { HomePageFragment.newInstance() }
    private val mySelfFragment:MySelfFragment by lazy { MySelfFragment.newInstance() }

    //暴露Homepage的ScannedImage给拍摄后显示图片使用
    fun getHomePageFragmentScannedView():ImageView? {
        return homePageFragment.view?.findViewById(R.id.home_page_scanned_image)
    }

    override fun createFragment(position: Int): Fragment =
        when(position) {
            SEARCH_PAGE_INDEX -> searchFragment
            HOME_PAGE_INDEX -> homePageFragment
            else -> mySelfFragment
        }

    override fun getItemCount(): Int = FRAGMENT_TOTAL_COUNT

}