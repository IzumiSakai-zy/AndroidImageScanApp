package com.whu.androidimagescanapp.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.adapter.ImageRecycleAdapter
import com.whu.androidimagescanapp.utils.CommonUtils

class MySelfFragment : Fragment(), View.OnClickListener {

    companion object {
        private const val ROUND_RADIUS = 500F

        @JvmStatic
        fun newInstance() = MySelfFragment()
    }

    private var headAvatar:ImageView? = null
    private var nameAndLocationIcon:ImageView? = null
    private var moreSettingsButton:ImageView? = null
    private var learnMoreButton:ImageView? = null
    private var recycleList:RecyclerView? = null

    private lateinit var imageResourceIndexList:List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_self, container, false).let {
            headAvatar = it.findViewById(R.id.myself_head_avatar)
            nameAndLocationIcon = it.findViewById(R.id.myself_name_and_location)
            moreSettingsButton = it.findViewById(R.id.myself_more_settings_button)
            learnMoreButton = it.findViewById(R.id.myself_learn_more_button)
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

        //设置recycleView
        setImageResourceIndexList()
        recycleList?.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = ImageRecycleAdapter(imageResourceIndexList)
        }

        //设置onClickListener
        headAvatar?.setOnClickListener(this)
        nameAndLocationIcon?.setOnClickListener(this)
        moreSettingsButton?.setOnClickListener(this)
        learnMoreButton?.setOnClickListener(this)
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

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.myself_head_avatar -> {
                CommonUtils.previewImage(activity, headAvatar)
            }
            R.id.myself_name_and_location,
            R.id.myself_more_settings_button,
            R.id.myself_learn_more_button -> {
                Toast.makeText(view.context, view.context.getString(R.string.have_not_implement), Toast.LENGTH_SHORT).show()
            }
        }
    }
}