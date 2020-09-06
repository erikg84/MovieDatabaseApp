package com.example.moviedatabaseapp.view

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.moviedatabaseapp.R
import com.example.moviedatabaseapp.databinding.FragmentMovieBinding
import com.example.moviedatabaseapp.model.MovieDBResponse
import com.example.moviedatabaseapp.util.MOVIE
import com.example.moviedatabaseapp.util.RESPONSE
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private var movies: MovieDBResponse? = null

    private var movieListSection = Section()
    private var movieAdapter = GroupAdapter<ViewHolder>().apply {
        add(movieListSection)
        setHasStableIds(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        movies = arguments?.getParcelable(RESPONSE)

        binding.moviesRv.apply {
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        movies?.results?.map { movie ->
            ResultsBindableItem(
                movie
            ) {
                val bundle = Bundle()
                bundle.putParcelable(MOVIE, movie as Parcelable)
                findNavController().navigate(R.id.next_movieDetailFragment, bundle)
            }
        }.also {
            if (it != null) {
                movieListSection.update(it)
            }
        }

        return binding.root
    }
}