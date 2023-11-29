package com.rokan.muslimpedia.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private val BASE_URL = "https://newsapi.org"
    private val API_KEY = "95d84e1ceba74249b0b2e9c196a74c26"

    fun provideApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder().addInterceptor{
            chain -> val newRequest = chain.request().newBuilder()
            .addHeader("X-Api-key" , API_KEY)
            .build()
            chain.proceed(newRequest)
        }
            .readTimeout(10 ,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

}