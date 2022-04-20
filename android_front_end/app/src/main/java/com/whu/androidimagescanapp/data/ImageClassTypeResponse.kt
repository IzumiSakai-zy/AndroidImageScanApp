package com.whu.androidimagescanapp.data

import com.google.gson.annotations.SerializedName

//  {
//      code: 200,
//      message: "success to classify image",
//      class_type: "cat"
//  }
data class ImageClassTypeResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("class_type")
    val classType: String
)



