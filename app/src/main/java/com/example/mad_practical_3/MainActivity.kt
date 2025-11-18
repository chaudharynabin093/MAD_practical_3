package com.example.mad_practical_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.provider.MediaStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.browse).setOnClickListener()
        {
            Intent(Intent.ACTION_VIEW,findViewById<EditText>(R.id.url).text.toString().toUri()).also { startActivity(it) }
        }

        findViewById<Button>(R.id.call).setOnClickListener()
        {
            val num= findViewById<EditText>(R.id.number).text.toString()
            val show = Intent(Intent.ACTION_DIAL,"tel:$num".toUri())
            startActivity(show)
        }

        findViewById<Button>(R.id.log).setOnClickListener {
            val show = Intent(Intent.ACTION_VIEW)
            show.setData("content://call_log/calls".toUri())
            startActivity(show)
        }

        findViewById<Button>(R.id.but_gallery).setOnClickListener {
            val show = Intent(Intent.ACTION_VIEW)
            show.setData("content://media/internal/images/media".toUri())
            startActivity(show)
        }

        findViewById<Button>(R.id.btn_camera).setOnClickListener {
            val show = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(show)
        }

        findViewById<Button>(R.id.btn_alarm).setOnClickListener {
        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            Intent(this, login::class.java).also{startActivity(it)}
        }

        findViewById<Button>(R.id.play_music).setOnClickListener {
            Intent(this, mediaPlayer::class.java).also { startActivity(it) }
        }
    }
}