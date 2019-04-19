package com.example.partielapimovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boButton.setOnClickListener {
            val intentListActivity = Intent(this, ListActivity::class.java)
            startActivity(intentListActivity)
        }

    }
}
