package com.nouman.gittreadingrepo.models


import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nouman.gittreadingrepo.utils.RoundedCornerImageView

data class Repo(
    var repoId: Int,
    var nodeId: String,
    var fullName: String?,
    var description: String?,
    var language: String?,
    var forks: Int,
    var starsCount: Int,
    val url: String?,
    var repoOwner: RepoOwner?
){
    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: RoundedCornerImageView, profileImage: String) {
            Glide.with(view.context)
                .load(profileImage)
                .into(view)
        }
    }
}