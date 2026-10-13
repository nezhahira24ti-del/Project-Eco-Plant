package com.example.nezhahira_3tic

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLogin : Button = findViewById(R.id.btnLogin)
        val username : EditText = findViewById(R.id.edtUsername)
        val password : EditText = findViewById(R.id.edtPassword)

        btnLogin.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            Log.d( "Username: ", user)
            Log.d( "Password: ",  user)

            Toast.makeText(this, "Usename: $user Password: $pass", Toast.LENGTH_LONG).show()
        }
    }
}