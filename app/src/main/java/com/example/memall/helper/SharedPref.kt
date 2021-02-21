package com.example.memall.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.FragmentActivity

class SharedPref(activity: Activity) {
    val login = "login"
    val mypref = "MAIN_PRF"
    val sp:SharedPreferences
    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean){
        sp.edit().putBoolean(login,status).apply()
    }

    fun getStatusLogin():Boolean {
        return sp.getBoolean(login, false)
    }
}