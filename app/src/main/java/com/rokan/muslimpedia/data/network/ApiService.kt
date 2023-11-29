package com.rokan.muslimpedia.data.network

import com.rokan.muslimpedia.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v2/everything")
    fun getCommonNews(
        @Query("q") query: String = "Common News",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 10,
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>


    @GET("/v2/everything")
    fun getBusinessNews(
        @Query("q") query: String = "Business",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSportNews(
        @Query("q") query: String = "Sports",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getPoliticNews(
        @Query("q") query: String = "Programming",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") query: String = "Search News",
        @Query("category") category: String = "General",
        @Query("pageSize") pageSize: Int = 10
    ): Call<NewsResponse>

}
