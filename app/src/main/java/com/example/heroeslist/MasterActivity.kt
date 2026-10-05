package com.example.heroeslist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {

    private lateinit var recyclerViewHeroes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerViewHeroes = findViewById(R.id.heroesRV)
        recyclerViewHeroes.adapter = HeroesAdapter(this.createHeroes(), this, { heroiEscolhido ->

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("HEROI_NOME", heroiEscolhido.heroName)
            intent.putExtra("HEROI_IMAGE", heroiEscolhido.heroImage)
            intent.putExtra("HEROI_COMPANY", heroiEscolhido.heroCompany)

            startActivity(intent)
        }
        )
        recyclerViewHeroes.layoutManager = LinearLayoutManager(this)
        recyclerViewHeroes.setHasFixedSize(true)
        recyclerViewHeroes.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }
    private fun createHeroes() : List<Heroes> {
        return listOf(
            Heroes(R.drawable.batman, "Batman", "DC Comics"),
            Heroes(R.drawable.hulk, "Hulk", "Marvel Entertainment"),
            Heroes(R.drawable.flash, "Flash", "DC Comics"),
            Heroes(R.drawable.drstrange, "Dr. Strange", "Marvel Entertainment"),
            Heroes(R.drawable.superman, "Superman", "DC Comics"),
            Heroes(R.drawable.ironman, "Iron Man", "Marvel Entertainment")
        )
    }
}