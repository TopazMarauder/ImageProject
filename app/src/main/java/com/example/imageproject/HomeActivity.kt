package com.example.imageproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.home_screen.*

class HomeActivity : AppCompatActivity() {

    var MyPREFERNCES = "myPrefs"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        var email = intent.getStringExtra("NAME")
        var sharedPref = getSharedPreferences(MyPREFERNCES, Context.MODE_PRIVATE)
        var password = sharedPref.getString("password key", "empty")

        if(email == "blankname"){
            var editor = sharedPref.edit()

            editor.putString("password key", "password, no login needed")
            editor.commit()
            email ="admin, no login needed"
        }
        text_view_welcome.text = "welcome $email, $password"



    }
}