package com.berramdane.tp2_movies.presentation.search

import com.berramdane.tp2_movies.domain.model.MovieShort

sealed class SearchState {

    class SuccessState(val movies: List<MovieShort>) : SearchState()

    object ErrorState : SearchState()

    object LoadingState : SearchState()


}