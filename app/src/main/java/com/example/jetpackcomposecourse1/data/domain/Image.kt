package com.example.jetpackcomposecourse1.data.domain

import com.google.gson.annotations.SerializedName

data class Image(
    val url : String,
    val author: String,
    val id : String,
    @SerializedName("download_url")
    val downloadUrl:String
)