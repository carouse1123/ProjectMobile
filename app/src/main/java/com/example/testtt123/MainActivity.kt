package com.example.testtt123


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.testtt123.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    val btnLogin = findViewById(R.id.btnLogin) as Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        btnLogin.setOnClickListener{

//            if(email.isEmpty()){
//                binding.etEmail.error = "Email Required"
//                binding.etEmail.requestFocus()
//                return@setOnClickListener
//            }
//
//            if(password.isEmpty()){
//                binding.etPassword.error = "Password required"
//                binding.etPassword.requestFocus()
//                return@setOnClickListener
//            }

        }
    fun clickLogin(v: View){
        val musicClient = musicAPI.create()
        musicClient.loginUser(binding.etEmail.text.toString(),
            binding.etPassword.text.toString()).enqueue(object: Callback<List<loginClass>>{
            override fun onFailure(call: Call<List<loginClass>>, t: Throwable) {
                Toast.makeText(applicationContext,"Wrong email or password " , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<loginClass>>, response: Response<List<loginClass>>) {
                if (response.isSuccessful){
                    val intent = Intent(applicationContext, test::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                }
            }
    })
        }
    fun clickCreate(v: View){
        val intent = Intent(this, signup::class.java)
        startActivity(intent)
    }

}
