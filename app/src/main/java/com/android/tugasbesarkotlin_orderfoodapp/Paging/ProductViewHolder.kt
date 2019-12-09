package com.android.tugasbesarkotlin_orderfoodapp.Paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.android.tugasbesarkotlin_orderfoodapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_menus.view.*

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(product: Product?){
        if (product != null){
            itemView.txt_name_product.text = product.name_product
            itemView.txt_harga_product.text = product.price
            Picasso.get().load(product.image).into(itemView.img_product)
        }
    }
    companion object{
        fun create(parent: ViewGroup): ProductViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menus, parent, false)

            return ProductViewHolder(view)

        }
    }
}

