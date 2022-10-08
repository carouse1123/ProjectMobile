package com.example.testtt123

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtt123.databinding.ProductItemLayoutBinding

class ProductAdapter (val items : List<ProductClass>, val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
        inner class ViewHolder(view: View, val binding: ProductItemLayoutBinding) :
            RecyclerView.ViewHolder(view) {
            init {
                binding.cardView.setOnClickListener {
                    val item = items!![adapterPosition]
                    val contextView:Context = view.context
                    val intent = Intent(contextView, DetailActivity::class.java)
                    intent.putExtra("Id",item.id)
                    intent.putExtra("Name",item.name)
                    intent.putExtra("Detail",item.detail)
                    intent.putExtra("Brand",item.brand)
                    intent.putExtra("Price",item.price.toString())
                    intent.putExtra("Img",item.image)
                    intent.putExtra("Num",item.amount.toString())
                    contextView.startActivity(intent)

                }
            }
            }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
                val binding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding.root, binding)
            }
            override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
                val binding = holder.binding
                binding.names.text = "ID: " +items!![position].name
                binding.brands.text = "Name: " +items!![position].brand
                binding.prices.text = "Brand: " +items!![position].price
                Glide.with(context).load(items!![position].image).into(binding.imageProduct)
            }

            override fun getItemCount(): Int {
                return items.size
            }
        }
