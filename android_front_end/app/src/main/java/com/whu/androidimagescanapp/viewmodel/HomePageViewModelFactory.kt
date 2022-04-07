package com.whu.androidimagescanapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 工厂获得ViewModel，适用于有参数的ViewModel
 */
class HomePageViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomePageViewModel() as T
    }
}
