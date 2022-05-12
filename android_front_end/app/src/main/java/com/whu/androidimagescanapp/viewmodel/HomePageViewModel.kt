package com.whu.androidimagescanapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()

    val result: LiveData<String>
        get() = _result

    init {
        _result.value = "It's a dog"
    }

    @SuppressLint("CheckResult")
    fun updateResult(result: String) {
        _result.value = "It's a cat"
    }

}