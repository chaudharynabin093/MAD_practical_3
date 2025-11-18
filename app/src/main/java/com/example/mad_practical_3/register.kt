package com.example.mad_practical_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Toast after Click on register
        findViewById<Button>(R.id.btn_register).setOnClickListener {
            Toast.makeText(this, "Registered Successful", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            Intent(this, login::class.java).also{startActivity(it)}
        }
    }
}