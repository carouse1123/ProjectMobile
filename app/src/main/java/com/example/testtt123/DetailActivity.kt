package com.example.testtt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtt123.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val proId = intent.getStringExtra("Id")
        val proName = intent.getStringExtra("Name")
        val proDetail = intent.getStringExtra("Detail")
        val proBrand = intent.getStringExtra("Brand")
        val proPrice = intent.getStringExtra("Price")
        val proImg = intent.getStringExtra("Img")
        val proAmount = intent.getStringExtra("Amount")

        binding.id.setText(proId)
        binding.names.text = "Name:$proName"
        binding.Detail.text = proDetail
        binding.brands.text = "Brand:$proBrand"
        binding.prices.text = "Name:$proPrice"
        Glide.with(this).load(proImg).into(binding.imageProduct)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

}