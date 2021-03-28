package com.mobilecomputing.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var loginBtn : Button
    private lateinit var username : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBtn = findViewById(R.id.login_btn)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_btn -> {
                val user = username.text.toString()
                val pass = password.text.toString()
                var emptyField = false

                if(user.isEmpty()) {
                    emptyField = true
                    username.error = "Tidak boleh kosong"
                }

                if(pass.isEmpty()) {
                    emptyField = true
                    password.error = "Tidak boleh kosong"
                }

                if(!emptyField) {
                    var authStatus = true

                    if(user != "admin") {
                        authStatus = false
                        username.error = "Username salah"
                    }

                    if(pass != "123") {
                        authStatus = false
                        password.error = "Password salah"
                    }

                    if(authStatus) {
                        val intent = Intent(this, AfterLogin::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }


}