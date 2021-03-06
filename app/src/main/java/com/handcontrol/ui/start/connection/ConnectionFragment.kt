package com.handcontrol.ui.start.connection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.handcontrol.R
import com.handcontrol.api.Api
import com.handcontrol.api.HandlingType


class ConnectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_connection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        val okButton: Button = view.findViewById(R.id.okButton) as Button

        val radioGroup: RadioGroup = view.findViewById(R.id.radios) as RadioGroup
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton_grpc -> {
                    okButton.setOnClickListener {
                        Api.setHandlingType(HandlingType.GRPC)
                        it.findNavController().navigate(R.id.action_connectionFragment_to_loginFragment)
                    }
                }
                R.id.radioButton_bluetooth -> {
                    okButton.setOnClickListener {
                        Api.setHandlingType(HandlingType.BLUETOOTH)
                        activity?.finish()
                        it.findNavController().navigate(R.id.action_global_navigation)
                    }
                }
            }

        }

    }
}