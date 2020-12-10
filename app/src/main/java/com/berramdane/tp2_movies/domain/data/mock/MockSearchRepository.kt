package com.berramdane.tp2_movies.domain.data.mock

import com.berramdane.tp2_movies.domain.model.MovieShort
import com.berramdane.tp2_movies.domain.repository.SearchRepository

class MockSearchRepository: SearchRepository {
    override suspend fun searchMovie(search: String): List<MovieShort> {
        return listOf(
            MovieShort("1","Titre 1","https://cdn.discordapp.com/attachments/336896465391845379/786258377117925446/arnaud.png"),
            MovieShort("2","Titre 2","https://media.discordapp.net/attachments/336896465391845379/786257247974064138/2Q.png?width=424&height=702"),
            MovieShort("3","Titre 3",""),
            MovieShort("4","Titre 4",""),
            MovieShort("5","Titre 5",""),
        )
    }

}