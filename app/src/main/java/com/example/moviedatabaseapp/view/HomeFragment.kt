package com.example.moviedatabaseapp.view

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviedatabaseapp.R
import com.example.moviedatabaseapp.databinding.FragmentHomeBinding
import com.example.moviedatabaseapp.model.MovieDBResponse
import com.example.moviedatabaseapp.util.RESPONSE
import com.example.moviedatabaseapp.viewmodel.MovieDbViewModel

class HomeFragment : Fragment() {

    private val vm = MovieDbViewModel()
    private lateinit var binding: FragmentHomeBinding
    private var movies = MovieDBResponse()

    init {
        vm.fetchMovies()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        vm.movieDBResponse.observe(viewLifecycleOwner, { movieList ->
            if(movieList != null)
                movies = movieList
        })

        binding.mainBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable(RESPONSE, movies as Parcelable)
            findNavController().navigate(R.id.next_SecondFragment, bundle)
        }
        return binding.root
    }
}