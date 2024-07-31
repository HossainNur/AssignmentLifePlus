package com.nurhossain.assignmentlifeplus.repository

import com.nurhossain.assignmentlifeplus.api.end_points.RetrofitClient
import com.nurhossain.assignmentlifeplus.api.models.SearchResponse

class SearchRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getSearch(query: String): SearchResponse {
        return apiService.getSearch(query)
    }
}