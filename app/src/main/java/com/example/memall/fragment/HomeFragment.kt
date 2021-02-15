package com.example.memall.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.memall.R
import com.example.memall.adapter.AdapterSlider

class HomeFragment : Fragment() {
    lateinit var vp_slider: ViewPager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        vp_slider = view.findViewById(R.id.vp_slider)
        //membuat array slider
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)
        val adapterSlider = AdapterSlider(arrSlider,activity)
        vp_slider.adapter = adapterSlider

        return view
    }
}