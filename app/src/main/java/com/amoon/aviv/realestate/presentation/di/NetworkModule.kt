package com.amoon.aviv.realestate.presentation.di

import com.amoon.aviv.realestate.BuildConfig
import com.amoon.aviv.realestate.data.network.RealEstateServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRealEstatesService(): RealEstateServices {
        val baseUrl = BuildConfig.BASE_URL
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RealEstateServices::class.java)
    }
}