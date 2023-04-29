package com.example.mvpsimpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.mvpsimpleapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), PresenterInterface {
    lateinit var binding: ActivityMainBinding

    lateinit var presenter: MainActivityPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)


        binding.edtName.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.updateFullName(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {}

        })


        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CoroutineScope(Dispatchers.Main).launch {
                    flowOf(p0.toString())
                        .onStart {
                            delay(1000L)
                        }
                        .collect {
                            presenter.updateEmail(it)
                        }

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    override fun updateUserInfoTextView(info: String) {
        binding.txtInfo.text = info
    }

    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }
}