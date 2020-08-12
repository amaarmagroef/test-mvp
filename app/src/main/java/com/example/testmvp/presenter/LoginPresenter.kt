package com.example.testmvp.presenter

import com.example.testmvp.datasource.DSContract
import com.example.testmvp.datasource.DSRepository
import com.example.testmvp.view.LoginContract
import java.util.regex.Pattern

class LoginPresenter(val view : LoginContract.View) : LoginContract.Presenter {
    val repository = DSRepository()

    init {
        view.setPresenter(this)
    }

    override fun isValidEmail(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    override fun isValidPassword(password: String): Boolean {
        return password.length>=6
    }

    override fun Login(email: String, password: String) {
        repository.login(email, password, object : DSContract.UserCallback{
            override fun onSucces() {
                view.showMain()
            }

            override fun onError(message: String, code: Int) {
                view.showError(message)
            }

        })
    }

    override fun start() {

    }

    override fun refresh() {

    }
}