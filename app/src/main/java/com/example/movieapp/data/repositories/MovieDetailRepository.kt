package com.example.movieapp.data.repositories

import com.example.movieapp.data.model.MovieDetail
import com.example.movieapp.data.network.ApiInterface
import com.example.movieapp.data.network.SafeApiRequest

class MovieDetailRepository(private val api: ApiInterface) : SafeApiRequest()
{
    suspend fun getMovieDetail(title: String, apiKey: String): MovieDetail
    {
        return apiRequest { api.getMovieDetailData(title, apiKey) }
    }
}