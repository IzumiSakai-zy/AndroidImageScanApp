package com.whu.androidimagescanapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.whu.androidimagescanapp.R

class HomePageFragment : Fragment() {

    companion object {
        const val TAG = "MAIN_PAGE_FRAGMENT"

        @JvmStatic
        fun newInstance() = HomePageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }
}