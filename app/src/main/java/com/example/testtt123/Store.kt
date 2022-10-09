package com.example.testtt123

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtt123.databinding.ActivityStoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class Store : AppCompatActivity() {
        private lateinit var binding : ActivityStoreBinding
        var ProductList = arrayListOf<ProductClass>()
        var DisplayList = arrayListOf<ProductClass>()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityStoreBinding.inflate(layoutInflater)
            setContentView(binding.root)
            
            binding.recyclerView.layoutManager = GridLayoutManager(this,2)

        }
        override fun onResume() {
            super.onResume()
            ProductList.clear();
            callProduct()
        }
        fun callProduct(){
            DisplayList.clear();
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
                            ProductList.add(ProductClass(it.id, it.name,it.detail,it.brand,it.price,it.image,it.amount))
                        }
                        DisplayList.addAll(ProductList)
                        binding.recyclerView.adapter = ProductAdapter(DisplayList,applicationContext)
                        binding.textviewProduct.text = "Product : "+ ProductList.size.toString()+""
                    }
                    override fun onFailure(call: Call<List<ProductClass>>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error onFailure " + t.message, Toast.LENGTH_LONG).show()
                    }
                }) }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_item,menu)
            val item = menu?.findItem(R.id.search)
            val searchView = item?.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    DisplayList.clear()
                    val searchText = newText!!.lowercase(Locale.getDefault())
                    if(searchText.isNotEmpty()){
                        ProductList.forEach{
                            if (it.name.lowercase(Locale.getDefault()).contains(searchText)){
                                DisplayList.add(it)
                            }
                        }
                        binding.recyclerView.adapter!!.notifyDataSetChanged()
                    }else{
                        DisplayList.clear()
                        DisplayList.addAll(ProductList)
                        binding.recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return false
                }

            })
            return super.onCreateOptionsMenu(menu)
        }
    }
