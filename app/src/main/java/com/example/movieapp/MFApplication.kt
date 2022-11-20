package com.example.movieapp

import android.app.Application
import com.example.movieapp.data.network.ApiInterface
import com.example.movieapp.data.network.NetworkConnectionInterceptor
import com.example.movieapp.data.repositories.HomeRepository
import com.example.movieapp.data.repositories.MovieDetailRepository
import com.example.movieapp.data.repositories.MovieListRepository
import com.example.movieapp.ui.home.HomeViewModelFactory
import com.example.movieapp.ui.moviedetail.MovieDetailViewModelFactory
import com.example.movieapp.ui.movielist.MovieListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class MFApplication : Application(), KodeinAware
{
    override val kodein = Kodein.lazy{
        import(androidXModule(this@MFApplication))

        bind() from this.singleton { NetworkConnectionInterceptor(this.instance()) }
        bind() from this.singleton { ApiInterface(this.instance()) }
        bind() from this.singleton { HomeRepository(this.instance()) }
        bind() from this.provider { HomeViewModelFactory(this.instance()) }
        bind() from this.singleton { MovieDetailRepository(this.instance()) }
        bind() from this.provider { MovieDetailViewModelFactory(this.instance()) }
        bind() from this.singleton { MovieListRepository(this.instance()) }
        bind() from this.provider { MovieListViewModelFactory(this.instance()) }
    }
}