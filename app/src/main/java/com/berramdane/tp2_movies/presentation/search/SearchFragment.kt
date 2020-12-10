package com.berramdane.tp2_movies.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.berramdane.tp2_movies.R

class SearchFragment : Fragment() {


    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_movie_search, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.fragment_movie_search_button)
        editText = view.findViewById(R.id.fragment_movie_search_bar)
        progressBar = view.findViewById(R.id.fragment_movie_progress_bar)
        recyclerView = view.findViewById(R.id.fragment_movie_recyclerView)

        adapter = SearchAdapter(requireContext())
        recyclerView.adapter = adapter

        button.setOnClickListener {
            viewModel.searchMovie(editText.text.toString())
        }

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

    }

    private fun updateState(state: SearchState) {
        when (state) {
            is SearchState.ErrorState -> {
                progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is SearchState.LoadingState -> {
                progressBar.isVisible = true
                adapter.setData(null)
            }
            is SearchState.SuccessState -> {
                progressBar.isVisible = false
                adapter.setData(state.movies)
            }

        }
    }
}