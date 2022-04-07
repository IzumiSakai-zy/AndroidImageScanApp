package com.whu.androidimagescanapp.item

import androidx.annotation.DrawableRes

class HistoryItem(val type:Int, @DrawableRes val drawableId:Int, val result:String) {
    companion object {
        const val CLASSIFICATION_TYPE = 0
        const val OCR_TYPE = 1
    }
}
