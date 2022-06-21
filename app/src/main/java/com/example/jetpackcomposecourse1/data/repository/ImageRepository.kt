package com.example.jetpackcomposecourse1.data.repository

import com.example.jetpackcomposecourse1.common.Response
import com.example.jetpackcomposecourse1.data.domain.Image
import com.example.jetpackcomposecourse1.data.domain.PicSumApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val picSumApi: PicSumApi
) {
    private suspend fun getImages(): List<Image> = picSumApi.getImages()

    fun getAllImages():Flow<Response<List<Image>>> = flow {
        try {
            emit(Response.Loading())
            val images = getImages()
            emit(Response.Success(images))
        }catch (e: HttpException){
            emit(Response.Error(e.localizedMessage ?: "Something went wrong Please rerun the application"))
        }catch (e: IOException){
            emit(Response.Error("There is something wrong with the server"))
        }
    }
}