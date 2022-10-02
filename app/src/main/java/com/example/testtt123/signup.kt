package com.example.testtt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import com.example.testtt123.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback



class signup : AppCompatActivity() {
    private lateinit var bindingInsert: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
    }
    fun Register(v: View){
        val musicClient = musicAPI.create()
        musicClient.registerUser(
            bindingInsert.etFullname.text.toString(),
            bindingInsert.etEmail.text.toString(),
            bindingInsert.etTel.text.toString(),
            bindingInsert.etPassword.text.toString()).enqueue(object : Callback<userClass> {
            override fun onResponse(call: Call<userClass>, response: retrofit2.Response<userClass>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext,"Successfully Inserted", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Error ", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<userClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure " + t.message, Toast.LENGTH_LONG).show()
            }
        })}
}