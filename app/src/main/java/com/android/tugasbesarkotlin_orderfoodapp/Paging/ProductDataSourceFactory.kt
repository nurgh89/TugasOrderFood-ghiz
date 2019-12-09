package com.android.tugasbesarkotlin_orderfoodapp.Paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Netwoking.NetworkService
import io.reactivex.disposables.CompositeDisposable


class ProductDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService
)
    : DataSource.Factory<Int, Product>() {

    val newsDataSourceLiveData = MutableLiveData<ProductDataSource>()

    override fun create(): DataSource<Int, Product> {
        val newsDataSource = ProductDataSource(networkService, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}