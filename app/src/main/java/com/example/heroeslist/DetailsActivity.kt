package com.example.heroeslist

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nome = intent.getStringExtra("HEROI_NOME")
        val image = intent.getIntExtra("HEROI_IMAGE", 0)
        val company = intent.getStringExtra("HEROI_COMPANY")

        findViewById<ImageView>(R.id.imageView).setImageResource(image)
        findViewById<TextView>(R.id.nomeHero).text = nome
        findViewById<TextView>(R.id.companyNome).text = company


        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}