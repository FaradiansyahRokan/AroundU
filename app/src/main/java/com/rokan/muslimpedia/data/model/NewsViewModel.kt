package com.rokan.muslimpedia.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rokan.muslimpedia.data.repository.NewsRepository

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    val commonNews : LiveData<NewsResponse> = repository.commonNews
    val BusinessNews: LiveData<NewsResponse> = repository.businessNews
    val SportNews: LiveData<NewsResponse> = repository.sportNews
    val PoliticNews: LiveData<NewsResponse> = repository.politicNews
    val searchNews: LiveData<NewsResponse> = repository.searchNews
    val isLoading: LiveData<Boolean> = repository.isLoading

    fun getCommonNews() {
        repository.getCommonNews()
    }


    fun getBusinessNews() {
        repository.getBusinessNews()
    }


    fun getSportNews() {
        repository.getSportNews()
    }


    fun getPoliticNews() {
        repository.getPoliticNews()
    }


    fun getSearchNews(q: String) {
        repository.getSearchNews(q)
    }

}