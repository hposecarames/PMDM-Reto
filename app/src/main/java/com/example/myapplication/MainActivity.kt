package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener{
            val intent = Intent(this, Reto1::class.java)
            startActivityForResult(intent, 1)
        }

        btn2.setOnClickListener{
            val intent = Intent(this, Reto2::class.java)
            startActivityForResult(intent, 2)
        }

        btn3.setOnClickListener{
            val intent = Intent(this, Reto3::class.java)
            startActivityForResult(intent, 3)
        }

        btn4.setOnClickListener{
            val intent = Intent(this, Reto4::class.java)
            startActivityForResult(intent, 4)
        }
    }


}
