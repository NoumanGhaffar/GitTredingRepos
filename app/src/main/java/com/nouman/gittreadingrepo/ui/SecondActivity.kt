package com.nouman.gittreadingrepo.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nouman.gittreadingrepo.R
import com.nouman.gittreadingrepo.databinding.ActivityMainBinding
import com.nouman.gittreadingrepo.models.Repo
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import com.nouman.gittreadingrepo.viewmodel.SecondViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: SecondViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUiAndData()
        getTreadingReposFromServer()
    }

    private fun getTreadingReposFromServer() {
        mainViewModel.getTrendingReposFromServer()
    }

    private fun initUiAndData() {
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnRetry.setOnClickListener {

            getTreadingReposFromServer()
        }
    }
}