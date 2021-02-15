package com.example.memall.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.memall.R
import com.example.memall.adapter.AdapterProduk
import com.example.memall.adapter.AdapterSlider
import com.example.memall.model.Produk

class HomeFragment : Fragment() {

    lateinit var vp_slider: ViewPager
    lateinit var rv_produk: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vp_slider = view.findViewById(R.id.vp_slider)
        rv_produk = view.findViewById(R.id.rv_produk)

        //membuat array slider
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)
        val adapterSlider = AdapterSlider(arrSlider,activity)
        vp_slider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rv_produk.adapter = AdapterProduk(arrProduk)
        rv_produk.layoutManager = layoutManager

        return view
    }

    val arrProduk:ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "HP Notebook 14 Core i3"
        p1.harga = "Rp 5.000.000"
        p1.gambar = R.drawable.hp_notebook_14_bs709tu

        val p2 = Produk()
        p2.nama = "HP Pavilion Core i5"
        p2.harga = "Rp 6.500.000"
        p2.gambar = R.drawable.hp_pavilion_13_an0006na

        val p3 = Produk()
        p3.nama = "HP Pavilion Cell Core i3"
        p3.harga = "Rp 4.500.000"
        p3.gambar = R.drawable.hp_pavilion_14_ce1507sa

        val p4 = Produk()
        p4.nama = "HP Pavilion Core i7"
        p4.harga = "Rp 5.000.000"
        p4.gambar = R.drawable.hp_pavilion_15_cx0056wm

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)

        return arr
    }
}