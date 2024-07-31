package com.nurhossain.assignmentlifeplus.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhossain.assignmentlifeplus.api.models.SearchResponse
import com.nurhossain.assignmentlifeplus.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    private val repository = SearchRepository()

    private val _searchResponse = MutableLiveData<SearchResponse>()
    val searchResponse : LiveData<SearchResponse> get() = _searchResponse

    fun getSearch(query: String){
        viewModelScope.launch {
            try {
                val response = repository.getSearch(query)
                _searchResponse.value = response
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}