package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val intent = Intent(this, Reto1::class.java)
            startActivityForResult(intent, 1)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, Reto2::class.java)
            startActivityForResult(intent, 2)
        }

        btn3.setOnClickListener {
            val intent = Intent(this, Reto3::class.java)
            startActivityForResult(intent, 3)
        }

        btn4.setOnClickListener {
            val intent = Intent(this, Reto4::class.java)
            startActivityForResult(intent, 4)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra("respuesta").equals("1801")) {
                    btn1.setBackgroundColor(Color.GREEN)
                    toast("Reto1 finalizado correctamente")
                }else{
                    btn1.setBackgroundColor(Color.RED)
                    toast("Reto1 fallado")
                }
            }
        }

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                if(data?.getBooleanExtra("respuesta2",false)!!.equals(true)){
                    btn2.setBackgroundColor(Color.GREEN)
                    toast("Reto2 finalizado correctamente")
                }else{
                    btn1.setBackgroundColor(Color.RED)
                    toast("Reto2 fallado")
                }
            }
        }

        if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("respuesta3").toString()).equals("9")) {
                    btn3.setBackgroundColor(Color.GREEN)
                    toast("Reto3 finalizado correctamente")
                }else{
                    btn1.setBackgroundColor(Color.RED)
                    toast("Reto3 fallado")
                }
            }
        }

    }
}

