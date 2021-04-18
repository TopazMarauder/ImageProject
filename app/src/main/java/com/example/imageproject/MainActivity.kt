package com.example.imageproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.splash_screen.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        init()

    }

    private fun init() {

        button_register.setOnClickListener(this)
        button_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.button_login -> {
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.button_register -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

        }


    }



}
/*

    override fun onStart() {
        super.onStart()
        Log.d("abc", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("abc", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("abc", "OnPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("abc", "OnStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("abc", "OnRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc", "OnDestroy()")
    }
}
*/
