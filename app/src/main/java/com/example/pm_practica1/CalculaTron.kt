package com.example.pm_practica1

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculaTron : AppCompatActivity() {
    //variables del activity
    private lateinit var fila1 : LinearLayout
    private lateinit var b1 : EditText
    private lateinit var b2 : EditText
    private lateinit var b3 : EditText

    private lateinit var fila2 : LinearLayout
    private lateinit var b4 : EditText
    private lateinit var b5 : EditText
    private lateinit var b6 : EditText

    private lateinit var fila3 : LinearLayout
    private lateinit var b7 : EditText
    private lateinit var b8 : EditText
    private lateinit var b9 : EditText

    private lateinit var fila4 : LinearLayout
    private lateinit var suma : EditText
    private lateinit var resta : EditText
    private lateinit var multiplicacion : EditText
    private lateinit var division : EditText

    private lateinit var iconoSup : ImageView
    private lateinit var contador : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcula_tron)

        //inicializa el resto
        fila1 = findViewById(R.id.fila1)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)

        fila2 = findViewById(R.id.fila2)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)

        fila3 = findViewById(R.id.fila3)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)

        fila4 = findViewById(R.id.fila4)
        suma = findViewById(R.id.sumar)
        resta = findViewById(R.id.restar)
        multiplicacion = findViewById(R.id.multiplicar)
        division = findViewById(R.id.dividir)
        iconoSup = findViewById(R.id.iconoSup)
        contador = findViewById(R.id.contador)

        var cuentas : Map<Boolean, String> = mapOf()

        object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {


            }
        }

    }
}