package com.islam.template.viewmodel

import androidx.lifecycle.ViewModel
import com.islam.template.utils.BaseSchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import javax.inject.Inject


open class BaseViewModel @Inject constructor(baseSchedulerProvider: BaseSchedulerProvider) : ViewModel() {

    private val subscribeOn: Scheduler = baseSchedulerProvider.io()
    private val observeOn: Scheduler = baseSchedulerProvider.ui()
    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun <T> execute(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Single<T>
    ) {
        val observable = useCase
            .doOnSubscribe(loadingConsumer)
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    private fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }

}