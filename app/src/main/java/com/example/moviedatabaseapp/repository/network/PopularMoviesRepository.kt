package com.example.moviedatabaseapp.repository.network

import com.example.moviedatabaseapp.model.MovieDBResponse
import com.example.moviedatabaseapp.util.API_KEY
import com.example.moviedatabaseapp.util.LANGUAGE
import com.example.moviedatabaseapp.util.PAGE

class PopularMoviesRepository {

    private val service: MovieDBService =
        MovieDBInstance.instance.create(MovieDBService::class.java)

    suspend fun popular(): MovieDBResponse =
         service.getPopularMovies(
                API_KEY,
                LANGUAGE,
                PAGE
            )
}