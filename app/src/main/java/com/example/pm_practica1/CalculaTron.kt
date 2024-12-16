package com.example.pm_practica1

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculaTron : AppCompatActivity() {

    //inicializar variables
    private lateinit var contador: TextView
    private lateinit var aciertos: TextView
    private lateinit var fallos: TextView
    private lateinit var cuentaAnterior: TextView
    private lateinit var cuentaActual: TextView
    private lateinit var cuentaSiguiente: TextView
    private lateinit var correccion: ImageView
    private lateinit var input: EditText
    private lateinit var barraSuperior: androidx.constraintlayout.widget.ConstraintLayout
    private lateinit var iconoSup: ImageView
    private lateinit var tituloanadir: EditText
    private lateinit var formulario: androidx.constraintlayout.widget.ConstraintLayout

    //inicializa los botones
    private lateinit var b0: androidx.appcompat.widget.AppCompatButton
    private lateinit var b1: androidx.appcompat.widget.AppCompatButton
    private lateinit var b2: androidx.appcompat.widget.AppCompatButton
    private lateinit var b3: androidx.appcompat.widget.AppCompatButton
    private lateinit var b4: androidx.appcompat.widget.AppCompatButton
    private lateinit var b5: androidx.appcompat.widget.AppCompatButton
    private lateinit var b6: androidx.appcompat.widget.AppCompatButton
    private lateinit var b7: androidx.appcompat.widget.AppCompatButton
    private lateinit var b8: androidx.appcompat.widget.AppCompatButton
    private lateinit var b9: androidx.appcompat.widget.AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcula_tron)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //asocia con la id
        contador = findViewById(R.id.contador)
        aciertos = findViewById(R.id.aciertos)
        fallos = findViewById(R.id.fallos)

        cuentaAnterior = findViewById(R.id.cuentaAnterior)
        cuentaActual = findViewById(R.id.cuentaActual)
        cuentaSiguiente = findViewById(R.id.cuentaSiguiente)
        correccion = findViewById(R.id.iconoAcierto)
        input = findViewById(R.id.input)
        barraSuperior = findViewById(R.id.barraSuperior)
        iconoSup = findViewById(R.id.iconoSup)
        tituloanadir = findViewById(R.id.tituloanadir)
        formulario = findViewById(R.id.formulario)


    }
}