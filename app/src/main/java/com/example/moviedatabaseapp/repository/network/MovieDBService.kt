package com.example.moviedatabaseapp.repository.network

import com.example.moviedatabaseapp.model.MovieDBResponse
import com.example.moviedatabaseapp.util.PATH
import retrofit2.http.*

interface MovieDBService {

    @GET(PATH)
    suspend fun getPopularMovies(@Query("api_key") apiKey: String,
                         @Query("language") language: String,
                         @Query("page") pageNumber: Int): MovieDBResponse

}