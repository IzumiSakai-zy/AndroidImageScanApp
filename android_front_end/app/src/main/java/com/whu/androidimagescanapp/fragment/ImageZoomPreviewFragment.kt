package com.whu.androidimagescanapp.fragment

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.whu.androidimagescanapp.R

class ImageZoomPreviewFragment : Fragment() {

    companion object {

        const val TAG = "image_zoom_preview_fragment"
        const val IMAGE_BUNDLE_KEY = "image_bit_map_parcel_key"

        @JvmStatic
        fun newInstance(bitmap: Bitmap?) = ImageZoomPreviewFragment().apply {
            //fragment间通过bundle传递数据
            Bundle().apply {
                putParcelable(IMAGE_BUNDLE_KEY, bitmap)
                arguments = this
            }
        }
    }

    private var previewImage:ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_zoom_preview, container, false).apply {
            previewImage = findViewById(R.id.preview_image)
            (arguments?.getParcelable(IMAGE_BUNDLE_KEY) as? Bitmap)?.let {
                previewImage?.setImageBitmap(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previewImage?.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}