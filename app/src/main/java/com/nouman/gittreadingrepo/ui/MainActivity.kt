package com.nouman.gittreadingrepo.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.nouman.gittreadingrepo.R
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        mainViewModel.getTrendingRepos().observe(this, {
            if (it != null) {
                Toast.makeText(
                    baseContext, "GOt the list size = " + it.repoList.size, Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    baseContext, "No List due = ", Toast.LENGTH_LONG
                ).show()
            }
        })
        mainViewModel.getTrendingReposFromServer()
    }

    private fun initData() {
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }
}