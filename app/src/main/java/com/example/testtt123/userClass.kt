package com.example.testtt123

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class userClass (
    @Expose
    @SerializedName("id") val id: Int,

    @Expose
    @SerializedName("fullname") val fullname:String,

    @Expose
    @SerializedName("email") val email:String,

    @Expose
    @SerializedName("tel") val tel:String,

    @Expose
    @SerializedName("password") val password:String){
}

data class loginClass(
    @Expose
    @SerializedName("email") val email:String,
    @Expose
    @SerializedName("password") val password:String){}

data class  ProductClass(
    @Expose
    @SerializedName("id") val id: Int,

    @Expose
    @SerializedName("name") val name:String,

    @Expose
    @SerializedName("detail") val detail:String,

    @Expose
    @SerializedName("brand") val brand:String,

    @Expose
    @SerializedName("price") val price:Double,

    @Expose
    @SerializedName("image") val image:String,

    @Expose
    @SerializedName("amount") val amount:Int){}