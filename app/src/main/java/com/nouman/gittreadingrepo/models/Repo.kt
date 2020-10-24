package com.nouman.gittreadingrepo.models

data class Repo(
    var repoId: Int,
    var nodeId: String,
    var fullName: String,
    var description: String,
    var language: String,
    var forks: Int
)