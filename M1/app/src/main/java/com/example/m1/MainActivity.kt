package com.example.m1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.m1.databinding.ActivitySigninBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById(R.id.button2) as Button

        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

    }
}