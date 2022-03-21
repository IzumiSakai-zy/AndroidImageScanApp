package com.whu.androidimagescanapp.adapter

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.ui.HomePageFragment
import com.whu.androidimagescanapp.ui.SearchFragment

class MainContainerViewPageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    companion object {
        const val FRAGMENT_TOTAL_COUNT = 2

        const val SEARCH_PAGE_INDEX = 0
        const val HOME_PAGE_INDEX = 1
    }

    private val homePageFragment:HomePageFragment by lazy { HomePageFragment.newInstance() }
    private val searchFragment:SearchFragment by lazy { SearchFragment.newInstance() }

    //暴露Homepage的ScannedImage给拍摄后显示图片使用
    fun getHomePageFragmentScannedView():ImageView? {
        return homePageFragment.view?.findViewById(R.id.home_page_scanned_image)
    }

    override fun createFragment(position: Int): Fragment =
        when(position) {
            HOME_PAGE_INDEX -> homePageFragment
            else -> searchFragment
        }

    override fun getItemCount(): Int = FRAGMENT_TOTAL_COUNT

}