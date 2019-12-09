package com.android.tugasbesarkotlin_orderfoodapp.Paging

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.android.tugasbesarkotlin_orderfoodapp.R
import kotlinx.android.synthetic.main.activity_menus_list_.*


class ProductListActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var newsListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus_list_)

        viewModel = ViewModelProviders.of(this)
            .get(ProductListViewModel::class.java)
        initAdapter()
        initState()
    }

    private fun initAdapter() {
        newsListAdapter = ProductListAdapter { viewModel.retry() }
        recycler_view.layoutManager = GridLayoutManager(this,  2)
        recycler_view.adapter = newsListAdapter
        viewModel.newsList.observe(this, Observer {
            newsListAdapter.submitList(it as PagedList<Product>?)
        })
    }

    private fun initState() {
        txt_txterror.setOnClickListener { viewModel.retry() }
        viewModel.getState().observe(this, Observer { state ->
            progressbar.visibility = if (viewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            txt_txterror.visibility = if (viewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()) {
                newsListAdapter.setState(state ?: State.DONE)
            }
        })
    }
}