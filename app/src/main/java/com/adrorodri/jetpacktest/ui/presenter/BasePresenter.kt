package com.adrorodri.jetpacktest.ui.presenter

import retrofit2.HttpException

open class BasePresenter(protected open val presenter: BasePresenterInterface?) {
    fun onError(error: Any) {
        when (error) {
            is HttpException -> presenter?.onError("Exception ${error.message}")
            is Throwable -> presenter?.onError("Ooops: Something else went wrong")
        }
    }
}