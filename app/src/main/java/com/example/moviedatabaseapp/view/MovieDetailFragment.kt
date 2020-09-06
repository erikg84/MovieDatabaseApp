package com.example.moviedatabaseapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moviedatabaseapp.R
import com.example.moviedatabaseapp.databinding.FragmentMovieDetailBinding
import com.example.moviedatabaseapp.model.ResultsItem
import com.example.moviedatabaseapp.util.Helpers
import com.example.moviedatabaseapp.util.MOVIE
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    private var movie: ResultsItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentMovieDetailBinding.inflate(layoutInflater, container, false)

        movie = arguments?.getParcelable(MOVIE)

        binding.movieData = movie

        Glide.with(this)
            .load(movie?.backdropPath?.let { Helpers.buildBackdropImageUrl(it) })
            .centerCrop()
            .into(binding.moviewIv)

        return binding.root
    }
}