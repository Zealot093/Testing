package com.example.testing.presentation

import com.arellomobile.mvp.MvpView

interface IBaseView : MvpView {

    fun lock()
    fun unlock()
    fun onSuccess(message: String)
    fun onError(message: String)
}