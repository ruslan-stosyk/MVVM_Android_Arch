package com.indeema.ble

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.indeema.ble.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentMainBinding: FragmentMainBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        fragmentMainBinding.welcomeListener = MainFragmentHandler()
        return fragmentMainBinding.root
    }

    inner class MainFragmentHandler {
        fun onWelcomeClick() {
            val name = enterName.text.toString()
            if (name.isEmpty()) {
                enterName.error = "Please enter a name"
            } else {
                val action = MainFragmentDirections.actionMainFragmentToDestinationFragment()
                action.name = name
                findNavController().navigate(action)
            }
        }
    }
}
