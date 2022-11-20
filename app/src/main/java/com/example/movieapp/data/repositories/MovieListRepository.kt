package com.example.movieapp.data.repositories


import com.example.movieapp.data.model.SearchResults
import com.example.movieapp.data.network.ApiInterface
import com.example.movieapp.data.network.SafeApiRequest

class MovieListRepository(private val api: ApiInterface) : SafeApiRequest()
{
    suspend fun getMovies(searchTitle: String, apiKey: String, pageIndex: Int): SearchResults
    {
        return apiRequest{ api.getSearchResultData(searchTitle, apiKey, pageIndex) }
    }
}