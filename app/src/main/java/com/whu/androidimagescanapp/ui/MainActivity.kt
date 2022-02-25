package com.whu.androidimagescanapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.whu.androidimagescanapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, MainPageFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }
}