package com.example.testmvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testmvp.R
import com.example.testmvp.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.View{
    var mPresenter : LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter = LoginPresenter(this)

    }

    override fun showLoading(show: Boolean) {

    }

    override fun showError(message: String) {
        showMessage(message)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

}