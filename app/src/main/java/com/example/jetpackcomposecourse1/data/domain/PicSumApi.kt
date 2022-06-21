package com.example.jetpackcomposecourse1.data.domain

import retrofit2.http.GET

interface PicSumApi {
    @GET("v2/list")
    suspend fun getImages():List<Image>
}