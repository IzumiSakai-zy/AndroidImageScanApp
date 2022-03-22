package com.whu.androidimagescanapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.whu.androidimagescanapp.R

class HomePageFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "MAIN_PAGE_FRAGMENT"

        @JvmStatic
        fun newInstance() = HomePageFragment()
    }

    private var nameEmailIcon:ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false).let {
            nameEmailIcon = it.findViewById(R.id.home_page_scanned_bottom_icon)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameEmailIcon?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.home_page_scanned_bottom_icon -> {
                Toast.makeText(view.context, view.context.getString(R.string.have_not_implement), Toast.LENGTH_SHORT).show()
            }
        }
    }
}