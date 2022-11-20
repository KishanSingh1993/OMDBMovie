package com.example.movieapp.ui.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.data.repositories.MovieListRepository

@Suppress("UNCHECKED_CAST")
class MovieListViewModelFactory(private val repository: MovieListRepository) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        return MovieListViewModel(repository) as T
    }
}