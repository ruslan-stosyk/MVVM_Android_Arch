package com.indeema.ble.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.indeema.ble.R
import com.indeema.ble.data.Device

class MainActivity : AppCompatActivity() {
    var device: Device? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host = NavHostFragment.create(R.navigation.welcome_nav_graph)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, host)
            .setPrimaryNavigationFragment(host).commit()
    }
}