package com.nouman.gittreadingrepo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nouman.gittreadingrepo.R
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var mainViewModel: MainViewModel
    init {
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}