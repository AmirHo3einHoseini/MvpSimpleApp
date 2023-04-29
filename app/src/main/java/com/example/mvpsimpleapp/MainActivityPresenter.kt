package com.example.mvpsimpleapp

import kotlinx.coroutines.flow.FlowCollector

class MainActivityPresenter(prInterface: PresenterInterface) {

    private val user: User
    private val prInterface: PresenterInterface

    init {
        this.prInterface = prInterface
        this.user = User("", "")
    }

    fun updateFullName(fullName: String) {
        user.name = fullName
        prInterface.updateUserInfoTextView(user.getUserInfo())
    }

    fun updateEmail(email: String) {
        user.email = email
        prInterface.updateUserInfoTextView(user.getUserInfo())
    }


}