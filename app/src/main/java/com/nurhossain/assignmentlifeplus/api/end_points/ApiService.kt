package com.nurhossain.assignmentlifeplus.api.end_points

import com.nurhossain.assignmentlifeplus.api.models.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("ott-content/search")
    suspend fun getSearch(@Query("q") query: String): SearchResponse

}