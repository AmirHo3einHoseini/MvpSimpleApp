package com.example.mvpsimpleapp

data class User(
    var name: String,
    var email: String

) {
    fun getUserInfo(): String {

        return "Email:$email\n FullName:$name "
    }
}

