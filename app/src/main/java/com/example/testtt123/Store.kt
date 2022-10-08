package com.example.testtt123

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testtt123.databinding.ActivityStoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Store : AppCompatActivity() {
        private lateinit var binding : ActivityStoreBinding
        var ProductList = arrayListOf<ProductClass>()
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityStoreBinding.inflate(layoutInflater)
            setContentView(binding.root)
            
            binding.recyclerView.layoutManager = GridLayoutManager(this,2)
            binding.recyclerView.addItemDecoration(DividerItemDecoration(
                binding.recyclerView.getContext(),DividerItemDecoration.VERTICAL)
            )
        }
        override fun onResume() {
            super.onResume()
            callProduct()
        }
        fun callProduct(){
            ProductList.clear();
            val serv : musicAPI = Retrofit.Builder() // Create Client
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(musicAPI ::class.java)
            serv.retrieveProduct()
                .enqueue(object : Callback<List<ProductClass>> {
                    override fun onResponse(call: Call<List<ProductClass>>, response: Response<List<ProductClass>>) {
                        response.body()?.forEach {
                            ProductList.add(ProductClass(it.id, it.name,it.detail,it.brand,it.price,it.image,it.amount)) }

                        binding.recyclerView.adapter = ProductAdapter(ProductList,applicationContext)
                        binding.textviewProduct.text = "All Product : "+ ProductList.size.toString()+"Product"
                    }
                    override fun onFailure(call: Call<List<ProductClass>>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error onFailure " + t.message, Toast.LENGTH_LONG).show()
                    }
                }) }

    }
