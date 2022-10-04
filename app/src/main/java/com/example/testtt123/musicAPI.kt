package com.example.testtt123

import android.database.Observable
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.Retrofit

interface musicAPI {
    @POST("register")
    @FormUrlEncoded
    fun registerUser(@Field("fullname") fullname:String,
                     @Field("email") email:String,
                     @Field("tel") tel:String,
                     @Field("password") password:String): Call<userClass>
    @POST("login")
    @FormUrlEncoded
    fun loginUser(@Field("email") email:String,
                  @Field("password") password:String,): Call<List<loginClass>>

    companion object{
        fun create():musicAPI{
            val musicClient : musicAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/") .addConverterFactory(
                    GsonConverterFactory.create())
                .build()
                .create(musicAPI ::class.java)
            return musicClient
        }
    }
}