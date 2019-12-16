package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.reto1.*
import org.jetbrains.anko.browse

class Reto1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reto1)

        btnVolver.setOnClickListener{
        val resp = Intent()
        resp.putExtra("respuesta", respuesta.toString())//Devolvemos el valor de la respuesta
        setResult(Activity.RESULT_OK, resp)
        finish()
        }

        btnBuscar.setOnClickListener{
            browse("https://es.wikipedia.org/wiki/Telar_de_Jacquard")
        }
    }

}