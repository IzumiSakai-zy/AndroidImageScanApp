package com.whu.androidimagescanapp.retrofit

import com.whu.androidimagescanapp.data.ImageClassTypeResponse
import io.reactivex.Observable
import retrofit2.http.POST


interface IImageClassificationService {
    @POST("/image")
    fun getImageClassType(): Observable<ImageClassTypeResponse>
}