package com.whu.androidimagescanapp.retrofit

import com.whu.androidimagescanapp.data.ImageClassTypeResponse
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface IImageClassificationService {
    @Multipart
    @POST("/classify-image")
    fun getImageClassType(@Part imageSource: MultipartBody.Part): Observable<ImageClassTypeResponse>
}