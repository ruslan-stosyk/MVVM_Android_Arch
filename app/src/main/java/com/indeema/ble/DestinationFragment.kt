package com.indeema.ble

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.indeema.ble.data.Device
import com.indeema.ble.databinding.FragmentDestinationBinding
import com.indeema.ble.ui.main.DeviceAdapter
import java.util.UUID

class DestinationFragment : Fragment() {

    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name =
            if (arguments != null) DestinationFragmentArgs.fromBundle(arguments!!).name else ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDestinationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_destination, container, false)
        binding.isProgress = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val r = Reread()
        r.execute(name)
    }

    inner class Reread : AsyncTask<String, Void, DeviceAdapter>() {
        override fun doInBackground(vararg p0: String?): DeviceAdapter {
            val name = p0[0]
            val deviceList: ArrayList<Device> = ArrayList()

            for (i in 1 until 100_000 step 2)
                deviceList.add(Device(UUID.randomUUID(), i.run { "$name is $i " }.toString()))
            return DeviceAdapter(deviceList)
        }

        override fun onPostExecute(result: DeviceAdapter?) {
            super.onPostExecute(result)
            view?.let { view ->
                val binding: FragmentDestinationBinding? = DataBindingUtil.findBinding(view)
                binding?.let { it.adapter = result; it.isProgress = false }
            }
        }
    }
}