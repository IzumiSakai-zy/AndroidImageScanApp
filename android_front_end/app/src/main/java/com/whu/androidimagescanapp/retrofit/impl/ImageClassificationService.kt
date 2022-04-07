package com.whu.androidimagescanapp.retrofit.impl

import com.whu.androidimagescanapp.data.ImageClassTypeResponse
import com.whu.androidimagescanapp.retrofit.IImageClassificationService
import com.whu.androidimagescanapp.utils.RetrofitUtil
import io.reactivex.Observable

object ImageClassificationService {
    private val service = RetrofitUtil.getRetrofitService().create(IImageClassificationService::class.java)

    fun getImageClassType(): Observable<ImageClassTypeResponse>  = service.getImageClassType()
}