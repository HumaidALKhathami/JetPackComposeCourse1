package com.example.jetpackcomposecourse1.di

import com.example.jetpackcomposecourse1.common.Constants
import com.example.jetpackcomposecourse1.data.domain.PicSumApi
import com.example.jetpackcomposecourse1.data.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApi(): PicSumApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicSumApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: PicSumApi):ImageRepository{
        return ImageRepository(api)
    }
}