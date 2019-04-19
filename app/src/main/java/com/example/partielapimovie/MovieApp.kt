package com.example.partielapimovie

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MovieApp: Application() {

    companion object {
        lateinit var requetQueue: RequestQueue
    }

    override fun onCreate() {
        super.onCreate()
        requetQueue = Volley.newRequestQueue(this)
    }

}