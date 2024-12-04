package com.example.pm_practica1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

    private var estadoCartas = Array(12) {0}

    private var pares = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)
    private var parejaId = intArrayOf(-1, -2)
    private var parejaPos = intArrayOf(-1, -2)

    private var contadorPareja = 0
    private var puntosVida = 10
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
            contadorPareja = 0
            puntosVida = 3
        }

        casillas = arrayOf(f1c1, f1c2, f1c3, f2c1, f2c2, f2c3, f3c1, f3c2, f3c3, f4c1, f4c2, f4c3)

        for (i in 0 .. 11) {
            casillas[i].setOnClickListener {
                if (contadorPareja != 2 && puntosVida >= 0) {
                    if (sePuedeVoltear(i)) {
                        voltearCarta(i)
                        parejaId[contadorPareja] = pares[i] //Asigno el valor de la carta a la variable par para comparar si tienen el mismo
                        parejaPos[contadorPareja] = i
                        Log.v("debug2", "id Carta: "+parejaId[contadorPareja])
                        Log.v("debug2", "pos Carta: "+parejaPos[contadorPareja])
                        contadorPareja++

                    }
                }
                if (contadorPareja == 2) {
                    if (sonPareja()) {
                        Log.v("debug2", "contador con: " + contadorPareja)
                        // Si son pareja, reinicia el contador para seguir buscando sin clic adicional
                        contadorPareja = 0
                    } else {
                        voltearCarta(i)
                        puntosVida -= 1
                        vidas.text = "Vidas: $puntosVida"
                        Log.v("debug2", "contador sin pareja: " + contadorPareja)
                        cartasTapar()
                        // Reinicia el contador de parejas aquí para continuar buscando inmediatamente
                        contadorPareja = 0
                    }
                }

                if (puntosVida <= 0) {
                    cartasTapar()
                    randomizarCartas()
                }
            }
        }
    }

    fun sePuedeVoltear(pos:Int):Boolean{
        return estadoCartas[pos] == 0
    }

    fun randomizarCartas(){
        pares.shuffle()
        vidas.text = "Vidas: 3"
    }

    fun voltearCarta(pos:Int){
//        casillas[pos].setImageResource(R.drawable.c1)
        when(pares[pos]){
            1 -> casillas[pos].setImageResource(R.drawable.coco)
            2 -> casillas[pos].setImageResource(R.drawable.corvilo)
            3 -> casillas[pos].setImageResource(R.drawable.aquilino)
            4 -> casillas[pos].setImageResource(R.drawable.pando)
            5 -> casillas[pos].setImageResource(R.drawable.alfonso)
            6 -> casillas[pos].setImageResource(R.drawable.saponcio)
        }
        estadoCartas[pos] = 1
    }

    fun cartasTapar(){
        for (i in 0 .. 11){
            if (estadoCartas[i] != 3){
                casillas[i].setImageResource(R.drawable.detras)
                estadoCartas[i] = 0
            }
        }
    }

    fun sonPareja(): Boolean {
        if(parejaId[0] == parejaId[1]){
            estadoCartas[parejaPos[0]] = 3
            estadoCartas[parejaPos[1]] = 3
        }
        contadorPareja = 0
        return parejaId[0] == parejaId[1]
    }


}