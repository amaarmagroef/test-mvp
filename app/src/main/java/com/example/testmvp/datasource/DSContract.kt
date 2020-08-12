package com.example.testmvp.datasource

interface DSContract {
    interface UserCallback{
        fun onSucces()
        fun onError(message : String, code : Int)
    }

    fun login(email : String, password : String, callback : UserCallback)
}