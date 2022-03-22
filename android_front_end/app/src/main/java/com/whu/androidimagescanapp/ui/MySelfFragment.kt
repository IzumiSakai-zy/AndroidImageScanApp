package com.whu.androidimagescanapp.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.adapter.ImageRecycleAdapter

class MySelfFragment : Fragment() {

    companion object {
        private const val ROUND_RADIUS = 500F

        @JvmStatic
        fun newInstance() = MySelfFragment()
    }

    private var headAvatar:ImageView? = null
    private var recycleList:RecyclerView? = null

    private lateinit var imageResourceIndexList:List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_self, container, false).let {
            headAvatar = it.findViewById(R.id.myself_head_avatar)
            recycleList = it.findViewById(R.id.myself_recycle_view)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //设置圆角
        val bitMap = BitmapFactory.decodeResource(resources, R.drawable.myself_head_avatar)
        RoundedBitmapDrawableFactory.create(resources, bitMap).apply {
            cornerRadius = ROUND_RADIUS
            setAntiAlias(true)
            headAvatar?.setImageDrawable(this)
        }

        setImageResourceIndexList()
        recycleList?.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = ImageRecycleAdapter(imageResourceIndexList)
        }
    }

    private fun setImageResourceIndexList() {
        imageResourceIndexList = mutableListOf(
            R.drawable.myself_libary_1,
            R.drawable.myself_libary_2,
            R.drawable.myself_libary_3,
            R.drawable.myself_libary_4,
            R.drawable.myself_libary_5,
            R.drawable.myself_libary_6
        )
    }
}