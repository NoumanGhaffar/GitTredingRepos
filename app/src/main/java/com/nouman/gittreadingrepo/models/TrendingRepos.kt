package com.nouman.gittreadingrepo.models
import com.nouman.gittreadingrepo.models.response.RepoResponse

data class TrendingRepos(
    var totalCount: Int,
    var repoList: List<Repo>
)