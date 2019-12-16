package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.reto2.*
import org.jetbrains.anko.longToast

class Reto2 : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_CAMERA = null
    val REQUEST_IMAGE_CAPTURE = 1
    var fotoRealizada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reto2)




        camara.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {



                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        android.Manifest.permission.CAMERA
                    )

                ) {

                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CAMERA),
                        1
                    )
                    longToast("No tienes permisos de acceso a Cámara")
                }
            } else {
                longToast("Tienes permiso para usar la camara")
                dispatchTakePictureIntent()
            }

        }
        btnVolver.setOnClickListener {
            val resp = Intent()
            resp.putExtra("respuesta2", fotoRealizada)
            setResult(Activity.RESULT_OK, resp)
            finish()
        }
        }
        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>, grantResults: IntArray
        ) {

            when (requestCode) {
                MY_PERMISSIONS_REQUEST_CAMERA -> {
                    // If request is cancelled, the result arrays are empty.
                    if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        dispatchTakePictureIntent()

                    } else {
                        // permission denied, boo! Disable the
                        // functionality that depends on this permission.
                    }
                    return
                }

                // Add other 'when' lines to check for other
                // permissions this app might request.
                else -> {

                }
            }
        }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagen.setImageBitmap(imageBitmap)
            fotoRealizada = true
        }

    }

}
