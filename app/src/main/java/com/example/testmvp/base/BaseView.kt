package com.example.testmvp.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}