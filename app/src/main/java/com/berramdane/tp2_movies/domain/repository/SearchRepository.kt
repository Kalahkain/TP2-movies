package com.berramdane.tp2_movies.domain.repository

import com.berramdane.tp2_movies.domain.model.MovieShort

interface SearchRepository {
    suspend fun searchMovie(search : String) : List<MovieShort>
}