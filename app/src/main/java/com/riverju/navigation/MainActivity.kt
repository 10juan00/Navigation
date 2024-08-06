package com.riverju.navigation
//com.riverju.navigation/MainActivity.kt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var signInBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInBtn = findViewById(R.id.SignIn)

        signInBtn.setOnClickListener {
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
