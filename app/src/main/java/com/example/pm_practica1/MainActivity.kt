package com.example.pm_practica1

import android.os.Bundle
import android.util.Log
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

    private var cartasVolteadas = Array(12) {false}
    private var pares = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)
    private var pareja = intArrayOf(-1, -2)
    private var contador = 0
    private var puntosVida = 3
    private lateinit var casillas :  Array<ImageView>

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

        randomizarCartas()

        iniciar.setOnClickListener {
            cartasTapar()
            randomizarCartas()
            contador = 0
            puntosVida = 3
        }

        casillas = arrayOf(f1c1, f1c2, f1c3, f2c1, f2c2, f2c3, f3c1, f3c2, f3c3, f4c1, f4c2, f4c3)

        for (i in 0 .. 11) {
            casillas[i].setOnClickListener {
                if (contador < 2 && puntosVida >= 0) {
                    var volteable = sePuedeVoltear(i)
                    if (volteable) {
                        voltearCarta(i)
                        pareja[contador] = pares[i] //Asigno el valor de la carta a la variable par para comparar si tienen el mismo
                        contador++

                    }
                } else {
                    val esPareja = sonPareja()
                    if (esPareja) {
                    } else {
                        puntosVida -= 1
                        vidas.text = "Vidas: "+puntosVida
                        cartasTapar()
                    }
                    contador = 0

                }
                if (puntosVida <= 0){
                    cartasTapar()
                    randomizarCartas()
                }
            }
        }
    }


    fun sePuedeVoltear(pos:Int):Boolean{
        if (!cartasVolteadas[pos]){
            cartasVolteadas[pos]
            return true
        }else return false
    }

    fun randomizarCartas(){
        pares.shuffle()
        vidas.text = "Vidas: 3"
    }

    fun voltearCarta(pos:Int){
//        casillas[pos].setImageResource(R.drawable.c1)
        when(pares[pos]){
            1 -> casillas[pos].setImageResource(R.drawable.coco)
            2 -> casillas[pos].setImageResource(R.drawable.agatan)
            3 -> casillas[pos].setImageResource(R.drawable.cleo)
            4 -> casillas[pos].setImageResource(R.drawable.pando)
            5 -> casillas[pos].setImageResource(R.drawable.parchesd)
            6 -> casillas[pos].setImageResource(R.drawable.pupas)
        }
        cartasVolteadas[pos] = true
    }

    fun cartasTapar(){
        for (i in 0 .. 11){
            casillas[i].setImageResource(R.drawable.volteada)
            cartasVolteadas[i] = false
        }
    }

    fun sonPareja(): Boolean {
        return pareja[0] == pareja[1]
    }


}