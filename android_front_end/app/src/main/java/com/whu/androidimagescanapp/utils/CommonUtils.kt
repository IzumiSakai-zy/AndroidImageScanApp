package com.whu.androidimagescanapp.utils

import android.content.Context

object CommonUtils {
    fun dip2px(context: Context, dpValue:Int):Int {
        val scale = context.resources.displayMetrics.density
        return  (dpValue * scale + 0.5f).toInt()
    }
}