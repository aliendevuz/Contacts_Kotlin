package com.example.contactskotlin.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.contactskotlin.R

class MainActivity : AppCompatActivity() {
    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val button = findViewById<Button>(R.id.open)
        button.setOnClickListener { open() }
    }

    private fun open() {
        val intent = Intent(context, ContactActivity::class.java)
        startActivity(intent)
        finish()
    }
}
