package com.indeema.ble.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indeema.ble.data.Device
import com.indeema.ble.databinding.ItemDeviceBinding

/**
 * @author Ruslan Stosyk
 * Date: November, 13, 2019
 * Time: 0:34
 */

class DeviceAdapter(private val devices: List<Device>) :
    RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DeviceViewHolder(ItemDeviceBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = devices.size

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.bind(devices[position])
    }

    inner class DeviceViewHolder(private val binding: ItemDeviceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(device: Device) {
            binding.device = device
            binding.executePendingBindings()
        }
    }
}