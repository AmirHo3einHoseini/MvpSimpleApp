package com.example.mvpsimpleapp

interface PresenterInterface {
    fun updateUserInfoTextView(info: String)
    fun showProgressBar()
    fun hideProgressBar()
}