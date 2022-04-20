package com.whu.androidimagescanapp.retrofit.impl

import com.whu.androidimagescanapp.data.ImageClassTypeResponse
import com.whu.androidimagescanapp.retrofit.IImageClassificationService
import com.whu.androidimagescanapp.utils.RetrofitUtil
import io.reactivex.Observable
import okhttp3.MultipartBody

object ImageClassificationService {
    private val service =
        RetrofitUtil.getRetrofitService().create(IImageClassificationService::class.java)

    fun getImageClassType(imageSource: MultipartBody.Part): Observable<ImageClassTypeResponse> =
        service.getImageClassType(imageSource)
}