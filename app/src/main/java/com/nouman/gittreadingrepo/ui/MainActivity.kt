package com.nouman.gittreadingrepo.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nouman.gittreadingrepo.R
import com.nouman.gittreadingrepo.databinding.ActivityMainBinding
import com.nouman.gittreadingrepo.models.Repo
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUiAndData()
        startShimmer()
        initTreadingRepoObserver()
        getTreadingReposFromServer()
    }

    private fun getTreadingReposFromServer() {
        mainViewModel.getTrendingReposFromServer()
    }

    private fun initTreadingRepoObserver() {
        mainViewModel.getTrendingRepos().observe(this, Observer {

            if (it != null && it.repoList.isNotEmpty()) {
                updateRecyclerView(it.repoList)
                stopShimmer()
            } else {
                stopShimmer()
                showErrorRetryView()
            }

        })
    }

    private fun showErrorRetryView() {
        binding.groupErrorRetry.visibility = View.VISIBLE
        binding.animationView.playAnimation()
    }

    private fun hideErrorRetryView() {
        binding.groupErrorRetry.visibility = View.GONE
    }

    private fun updateRecyclerView(repoList: List<Repo>) {
        binding.rvRepos.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvRepos.adapter = RepoAdapter(repoList)
    }

    private fun initUiAndData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnRetry.setOnClickListener {
            hideErrorRetryView()
            startShimmer()
            getTreadingReposFromServer()
        }
    }

    private fun startShimmer() {
        binding.shimmerLayout.startShimmer()
        binding.shimmerLayout.visibility = View.VISIBLE
    }

    private fun stopShimmer() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }
//    supportFragmentManager.beginTransaction()
//    .replace(R.id.container, MainFragment.newInstance())
//    .commitNow()
}