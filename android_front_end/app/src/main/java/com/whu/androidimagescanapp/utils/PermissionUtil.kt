package com.whu.androidimagescanapp.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat


object PermissionUtil {

    fun checkPermission(context: Context, permission: String): Boolean =
        ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}