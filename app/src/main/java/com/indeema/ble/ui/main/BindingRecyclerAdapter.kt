package com.indeema.ble.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Ruslan Stosyk
 * Date: November, 13, 2019
 * Time: 0:57
 */

@BindingAdapter(value = ["app:adapter"])
fun setAdapter(recyclerView: RecyclerView, adapter: DeviceAdapter) {
    recyclerView.adapter = adapter
}