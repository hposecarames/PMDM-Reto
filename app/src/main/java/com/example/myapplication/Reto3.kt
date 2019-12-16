package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.reto3.*
import org.jetbrains.anko.db.INTEGER


class Reto3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reto3)

        var nu1 = 0
        var nu2 = 0

        btnmultiplicar.setOnClickListener {

            nu1 = Integer.parseInt(num1.text.toString())
            nu2 = Integer.parseInt(num2.text.toString())

            resultado.text = (nu1 * nu2).toString()
        }
        btnVolver.setOnClickListener {
            val resp = Intent()
            resp.putExtra("respuesta3", resultado.toString())
            setResult(Activity.RESULT_OK, resp)
            finish()
        }
    }
}