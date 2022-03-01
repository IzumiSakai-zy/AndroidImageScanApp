package com.whu.androidimagescanapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.facebook.drawee.backends.pipeline.Fresco
import com.whu.androidimagescanapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(R.layout.activity_main)

        Fresco.initialize(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, OpeningFragment.newInstance(), OpeningFragment.TAG)
                .addToBackStack(OpeningFragment.TAG)
                .commit()
        }
    }
}