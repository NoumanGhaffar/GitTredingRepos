package com.nouman.gittreadingrepo.models.response

import com.example.seezassignment.network.response.BaseResponse
import com.google.gson.annotations.SerializedName
import com.nouman.gittreadingrepo.models.TrendingRepos

data class TrendingReposResponse(
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("items")
    var repoList: List<RepoResponse>
) : BaseResponse<TrendingRepos>() {
    override fun toModel() =
        TrendingRepos(totalCount, repoList)
}


