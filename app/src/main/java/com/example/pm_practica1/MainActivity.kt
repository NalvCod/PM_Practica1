package com.example.pm_practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var f1c1 : ImageView
    private lateinit var f1c2 : ImageView
    private lateinit var f1c3 : ImageView
    private lateinit var f2c1 : ImageView
    private lateinit var f2c2 : ImageView
    private lateinit var f2c3 : ImageView
    private lateinit var f3c1 : ImageView
    private lateinit var f3c2 : ImageView
    private lateinit var f3c3 : ImageView
    private lateinit var f4c1 : ImageView
    private lateinit var f4c2 : ImageView
    private lateinit var f4c3 : ImageView
    private lateinit var vidas : TextView
    private lateinit var iniciar : Button

    private var mesaCartas = Array(3){Array(3) {0} }
    private lateinit var casillas :  List<List<ImageView>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f1c1 = findViewById(R.id.f1c1)
        f1c2 = findViewById(R.id.f1c2)
        f1c3 = findViewById(R.id.f1c3)
        f2c1 = findViewById(R.id.f2c1)
        f2c2 = findViewById(R.id.f2c2)
        f2c3 = findViewById(R.id.f2c3)
        f3c1 = findViewById(R.id.f3c1)
        f3c2 = findViewById(R.id.f3c2)
        f3c3 = findViewById(R.id.f3c3)
        f4c1 = findViewById(R.id.f4c1)
        f4c2 = findViewById(R.id.f4c2)
        f4c3 = findViewById(R.id.f4c3)
        vidas = findViewById(R.id.vidas)
        iniciar = findViewById(R.id.iniciar)

        iniciar.setOnClickListener {
            iniciarPartida()
        }

        casillas = listOf(
            listOf(f1c1, f1c2, f1c3),
            listOf(f2c1, f2c2, f2c3),
            listOf(f3c1, f3c2, f3c3),
            listOf(f4c1, f4c2, f4c3)
        )

    }

    fun iniciarPartida(){



    }
}