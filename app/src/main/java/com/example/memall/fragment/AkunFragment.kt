package com.example.memall.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.memall.R
import com.example.memall.helper.SharedPref

class AkunFragment : Fragment() {
    lateinit var s:SharedPref
    lateinit var btnLogout:Button
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btn_logout)
        s = SharedPref(activity!!)
        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }
        return view
    }
}