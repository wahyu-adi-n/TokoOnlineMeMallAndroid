package com.example.memall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.memall.activity.LoginActivity
import com.example.memall.fragment.AkunFragment
import com.example.memall.fragment.HomeFragment
import com.example.memall.fragment.KeranjangFragment
import com.example.memall.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val fragmentHome: Fragment=HomeFragment()
    private val fragmentAkun: Fragment=AkunFragment()
    private val fragmentKeranjang: Fragment=KeranjangFragment()
    private val fm: FragmentManager=supportFragmentManager // untuk menandai fragment aktif sebagai default
    private var active: Fragment =  fragmentHome
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        s = SharedPref(this)
        setUpNavBottom()
    }

    private fun setUpNavBottom() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0) //default menu seperti array, dimulai dari 0
        menuItem.isChecked =  true
        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home ->{
                    panggilFragment(0,fragmentHome)
                }
                R.id.navigation_keranjang ->{
                    panggilFragment(1, fragmentKeranjang)
                }
                R.id.navigation_akun ->{
                    if (s.getStatusLogin()) {
                        panggilFragment(2, fragmentAkun)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
            false
        }
    }

    private fun panggilFragment(int:Int, fragment:Fragment) {
        Log.d("Response", "Home")
        menuItem = menu.getItem(int) //default menu seperti array, dimulai dari 0
        menuItem.isChecked =  true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}