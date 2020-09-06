package com.example.moviedatabaseapp.viewmodel

import androidx.lifecycle.*
import com.example.moviedatabaseapp.model.MovieDBResponse
import com.example.moviedatabaseapp.repository.network.PopularMoviesRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieDbViewModel: ViewModel() {

    private val repo = PopularMoviesRepository()

    private val _movieDBResponse = MutableLiveData<MovieDBResponse>()
    val movieDBResponse: LiveData<MovieDBResponse>
        get() = _movieDBResponse.distinctUntilChanged()

    fun fetchMovies() {
        viewModelScope.launch {
            val job: Deferred<MovieDBResponse> =
                async(Dispatchers.IO) { repo.popular() }
            _movieDBResponse.postValue(job.await())
        }
    }

}