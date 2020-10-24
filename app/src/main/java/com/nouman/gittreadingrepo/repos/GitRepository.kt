package com.nouman.gittreadingrepo.repos

import com.nouman.gittreadingrepo.models.TrendingRepos
import com.nouman.gittreadingrepo.network.GitApi
import javax.inject.Inject

class GitRepository @Inject constructor(
    private val gitApi: GitApi
) {
    suspend fun getTrendingRepos(): TrendingRepos {
        return gitApi.getTrendingRepos()
    }
}