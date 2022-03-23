package com.whu.androidimagescanapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.drawToBitmap
import androidx.fragment.app.FragmentActivity
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.fragment.ImageZoomPreviewFragment

object CommonUtils {
    fun dip2px(context: Context, dpValue:Int):Int {
        val scale = context.resources.displayMetrics.density
        return  (dpValue * scale + 0.5f).toInt()
    }

    fun previewImage(fragmentActivity: FragmentActivity?, imageView: ImageView?) {
        fragmentActivity ?: return
        imageView ?: return
        if (!ViewCompat.isLaidOut(imageView)) {
            Toast.makeText(fragmentActivity, fragmentActivity.getString(R.string.try_again_letter), Toast.LENGTH_SHORT).show()
            return
        }
        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_container, ImageZoomPreviewFragment.newInstance(imageView.drawToBitmap()), ImageZoomPreviewFragment.TAG)
            .addToBackStack(ImageZoomPreviewFragment.TAG)
            .commit()
    }

    fun getCroppedAndBlurredBitmap(source:Bitmap):Bitmap {

        val height = source.height
        val width = source.width

        val croppedBitmap =  when {
            height == width -> source
            height > width -> {
                Bitmap.createBitmap(source,0,(height - width)/2, width, width,null,true)
            }
            else -> {
                Bitmap.createBitmap(source,(width - height) / 2,0, height, height,null,true)
            }
        }
        return Bitmap.createScaledBitmap(croppedBitmap, ConstValueUtil.CLASSIFICATION_IMAGE_PIXEL, ConstValueUtil.CLASSIFICATION_IMAGE_PIXEL,true)
    }
}