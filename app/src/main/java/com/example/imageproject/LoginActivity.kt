package com.example.imageproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login_screen.*


class LoginActivity : AppCompatActivity(), View.OnClickListener {


    var MyPREFERNCES = "myPrefs"
    var loginemail = "email key"
    var loginpassword = "password key"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        var sharedprefs = getSharedPreferences(MyPREFERNCES, Context.MODE_PRIVATE)
        var cpassword = sharedprefs.getString("password key", "empty")
        if(cpassword == "123"){
            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("NAME", "blankname")
            startActivity(intent)
        }

        init()
    }

    private fun init() {

        button_login.setOnClickListener(this)
        button_register.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.button_login -> {
                var givenEmail = enter_email.text.toString()
                var givenPassword = enter_password.text.toString()



                if (UserList.checkUser(givenEmail, givenPassword)){
                    var sharedprefs = getSharedPreferences(MyPREFERNCES, Context.MODE_PRIVATE)
                    var editor = sharedprefs.edit()

                    editor.putString(loginemail, givenEmail)
                    editor.putString(loginpassword, givenPassword)
                    editor.commit()



                    var intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("NAME", givenEmail)
                    startActivity(intent)

                }
                else {
                    Toast.makeText(applicationContext, "incorrect username or password", Toast.LENGTH_LONG).show()
                }


            }

            R.id.button_register -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

    }


}
