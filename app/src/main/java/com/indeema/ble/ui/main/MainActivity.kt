package com.indeema.ble.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indeema.ble.R
import com.indeema.ble.data.Device

class MainActivity : AppCompatActivity() {
    var device: Device? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}