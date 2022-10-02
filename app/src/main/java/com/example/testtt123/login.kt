package com.example.testtt123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.testtt123.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
    }
    fun clickCreate(v:View){
        val intent = Intent(this, signup::class.java)
        startActivity(intent)
    }
}