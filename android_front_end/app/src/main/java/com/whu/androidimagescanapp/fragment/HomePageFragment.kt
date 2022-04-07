package com.whu.androidimagescanapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.utils.CommonUtils
import com.whu.androidimagescanapp.viewmodel.HomePageViewModel
import com.whu.androidimagescanapp.viewmodel.HomePageViewModelFactory

class HomePageFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "MAIN_PAGE_FRAGMENT"

        @JvmStatic
        fun newInstance() = HomePageFragment()
    }

    var scannedImage:ImageView? = null
    private var nameEmailIcon:ImageView? = null
    private var predictedResult:TextView? = null

    private var viewModel: HomePageViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel  = ViewModelProvider(requireActivity(), HomePageViewModelFactory()).get(HomePageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false).apply {
            scannedImage = findViewById(R.id.home_page_scanned_image)
            nameEmailIcon = findViewById(R.id.home_page_scanned_bottom_icon)
            predictedResult = findViewById(R.id.home_page_predicted_result)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scannedImage?.setOnClickListener(this)
        nameEmailIcon?.setOnClickListener(this)

        viewModel?.result?.observe(this) {
            predictedResult?.text = it
        }
    }

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.home_page_scanned_image -> {
                CommonUtils.previewImage(activity, scannedImage)
            }
            R.id.home_page_scanned_bottom_icon -> {
                Toast.makeText(view.context, view.context.getString(R.string.have_not_implement), Toast.LENGTH_SHORT).show()
            }
        }
    }
}