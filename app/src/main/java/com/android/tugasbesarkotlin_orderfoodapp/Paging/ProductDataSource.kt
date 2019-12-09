package com.android.tugasbesarkotlin_orderfoodapp.Paging


import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.android.tugasbesarkotlin_orderfoodapp.Paging.Netwoking.NetworkService
import io.reactivex.Completable

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class ProductDataSource (
    private val networkService: NetworkService,
    private val compositeDisposable: CompositeDisposable):PageKeyedDataSource<Int, Product>(){

    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {
       updateState(State.LOADING)
        compositeDisposable.add(
            networkService.getNews(params.key, params.requestedLoadSize).subscribe(

                {response ->
                    updateState(State.DONE)
                    callback.onResult(response.product, params.key + 1)

                },
                {
                    updateState(State.ERROR)
                    setRetry(Action{loadAfter(params, callback )})
                }
            )

        )
    }

    private fun setRetry(action: Action) {

        retryCompletable = if (action == null) null else Completable.fromAction(action)

    }

    private fun updateState(state: State) {
        this.state.postValue(state)

    }
    fun retry(){
        if (retryCompletable != null){
            compositeDisposable.add(retryCompletable!!
                .subscribeOn(Schedulers.io() )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {

    }



    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Product>) {
        updateState(State.LOADING)
        compositeDisposable.add(
            networkService.getNews(1, params.requestedLoadSize).subscribe(
                {response ->
                    updateState(State.DONE)
                    callback.onResult(response.product,
                        null,
                        2
                    )
                },
                {
                    updateState(State.ERROR)
                    setRetry(Action{ loadInitial(params, callback) })
                }
            )
        )
    }
}
