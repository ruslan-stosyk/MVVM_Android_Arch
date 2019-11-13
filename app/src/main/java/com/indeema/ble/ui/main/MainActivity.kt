package com.indeema.ble.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.indeema.ble.R
import com.indeema.ble.data.Device
import com.indeema.ble.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val deviceList: ArrayList<Device> = ArrayList()
        for (i in 1 until 100_000 step 2)
            deviceList.add(Device(UUID.randomUUID(), i.run { i*10000 }.toString()))
        binding.adapter = DeviceAdapter(deviceList)
    }
}