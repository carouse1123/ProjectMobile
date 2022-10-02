package com.example.testtt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class login : AppCompatActivity() {
    var etusername: EditText? = null
    var etpassword: EditText? = null
    var btnlogin: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etusername = findViewById(R.id.etUsername)
        etpassword = findViewById(R.id.etPassword)
        btnlogin = findViewById(R.id.btnLogin)

    }
}