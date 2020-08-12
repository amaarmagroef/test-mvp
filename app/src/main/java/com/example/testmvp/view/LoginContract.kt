package com.example.testmvp.view

import com.example.testmvp.base.BasePresenter
import com.example.testmvp.base.BaseView

interface LoginContract {
    interface  Presenter : BasePresenter {
        fun isValidEmail(email : String) : Boolean
        fun isValidPassword(password : String) : Boolean
        fun Login(email : String, password: String)
    }

    interface View : BaseView<Presenter> {
        fun showLoading(show : Boolean)
        fun showError(message : String)
        fun showMessage(message : String)
        fun showMain()
    }
}