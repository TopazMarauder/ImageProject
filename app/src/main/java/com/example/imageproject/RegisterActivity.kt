package com.example.imageproject

import android.Manifest
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.register_screen.*
import androidx.activity.result.contract.ActivityResultContracts

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)
        init()

    }

    private fun init() {
        button_login.setOnClickListener(this)
        button_register.setOnClickListener(this)

        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    Toast.makeText(applicationContext, "approved", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "denied", Toast.LENGTH_LONG).show()
                }
            }
        requestPermissionLauncher.launch(
            Manifest.permission.CAMERA)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_register -> {
                var givenName = enter_username.text.toString()
                var givenEmail = enter_email.text.toString()
                if (enter_passwordprimary.text.toString() == enter_passwordsecondary.text.toString()) {
                    var givenPassword = enter_passwordprimary.text.toString()
                    UserList.addUser(givenName, givenEmail, givenPassword)

                    Toast.makeText(applicationContext, "new user $givenName registered", Toast.LENGTH_LONG).show()
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "passwords do not match", Toast.LENGTH_LONG).show()
                }
            }
            R.id.button_login -> {
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
    }
}