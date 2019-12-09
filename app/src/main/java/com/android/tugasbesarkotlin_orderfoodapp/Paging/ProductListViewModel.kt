package com.android.tugasbesarkotlin_orderfoodapp.Paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Netwoking.NetworkService
import io.reactivex.disposables.CompositeDisposable

class ProductListViewModel : ViewModel() {

    private val networkService = NetworkService.getService()
    var newsList: LiveData<PagedList<Product>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val newsDataSourceFactory: ProductDataSourceFactory

    init {
        newsDataSourceFactory = ProductDataSourceFactory(compositeDisposable, networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder<Int, Product>(newsDataSourceFactory, config).build()
    }


    fun getState(): LiveData<State> = Transformations.switchMap<ProductDataSource,
            State>(newsDataSourceFactory.newsDataSourceLiveData, ProductDataSource::state)

    fun retry() {
        newsDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}