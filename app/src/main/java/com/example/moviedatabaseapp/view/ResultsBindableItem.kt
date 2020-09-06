package com.example.moviedatabaseapp.view

import com.bumptech.glide.Glide
import com.example.moviedatabaseapp.R
import com.example.moviedatabaseapp.databinding.MovieItemBinding
import com.example.moviedatabaseapp.model.ResultsItem
import com.example.moviedatabaseapp.util.Helpers
import com.xwray.groupie.databinding.BindableItem

class ResultsBindableItem(
    private val item: ResultsItem?,
    private val onSelectedMovie: (ResultsBindableItem) -> Unit
) : BindableItem<MovieItemBinding>() {

    override fun getLayout() = R.layout.movie_item

    override fun bind(viewBinding: MovieItemBinding, position: Int) {
        viewBinding.apply {
            itemMoreName.text = item?.title

            itemMoreReleaseDate.text = item?.releaseDate

            container.setOnClickListener {
                onSelectedMovie(this@ResultsBindableItem)
            }

            Glide.with(viewBinding.root.context)
                .load(item?.posterPath?.let { Helpers.buildImageUrl(it) })
                .centerCrop()
                .into(itemMoreImage)
        }
    }

}