package com.nouman.gittreadingrepo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nouman.gittreadingrepo.models.TrendingRepos
import com.nouman.gittreadingrepo.repos.GitRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val gitRepository: GitRepository
) : ViewModel() {
    private val trendingRepos = MutableLiveData<TrendingRepos>()

    fun getTrendingRepos(): MutableLiveData<TrendingRepos> {
        return trendingRepos
    }

    fun getTrendingReposFromServer() {
        viewModelScope.launch {
            runCatching {
                gitRepository.getTrendingRepos()
            }.onSuccess {
                trendingRepos.value = it
            }.onFailure {
                trendingRepos.value = null
            }
        }
    }


}