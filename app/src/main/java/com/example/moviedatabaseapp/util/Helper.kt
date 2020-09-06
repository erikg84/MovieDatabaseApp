package com.example.moviedatabaseapp.util

object Helpers {

    fun buildSearchMovieUrl(query: String, pageNumber: Int, adult: String = "false"):String{
        return "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY +
                "&language=en-US&query=" + query + "&page="+pageNumber+"&include_adult="+adult+"&region=US|IN|UK"+"&with_release_type=2|3"
    }

    fun buildUpcomingMoviesUrl(pageNumber: Int, adult: String = "false"): String{
        return "https://api.themoviedb.org/3/movie/upcoming?api_key="+ API_KEY+
                "&language=en-US"+"&page="+pageNumber+"&region=US|IN|UK"+"&with_release_type=2|3"
    }

    fun buildTopRatedMoviesUrl(pageNumber: Int, adult: String = "false"): String{
        return BASE_URL +"movie/top_rated?api_key="+API_KEY+
                "&language=en-US&page="+pageNumber
    }

    fun buildNowShowingMoviesUrl(pageNumber: Int, adult: String = "false"): String{
        return BASE_URL +"movie/now_playing?api_key="+API_KEY+
                "&language=en-US&page="+pageNumber+"&region=US|IN|UK"
    }

    fun buildRecommendedMoviesUrl(pageNumber: Int, movieId: String): String{
        return BASE_URL + "movie/"+movieId+"/recommendations?" +
                "api_key="+ API_KEY+"&language=en-US&page="+pageNumber
    }

    fun buildPopularMoviesUrl(pageNumber: Int, adult: String = "false"): String{
        return BASE_URL +"movie/popular?api_key="+API_KEY+
                "&language=en-US&page="+pageNumber+"&region=US|IN|UK"
    }

    fun buildMovieCastUrl(movieId: String): String{
        return BASE_URL +"movie/"+movieId+"/credits?api_key="+ API_KEY
    }

    fun buildProfileImageUrl(path: String): String {
        return "http://image.tmdb.org/t/p/w185" + path
    }

    fun buildImageUrl(path: String): String {
        return "https://image.tmdb.org/t/p/w342" + path
    }

    fun buildBackdropImageUrl(path: String): String {
        return "https://image.tmdb.org/t/p/w780" + path
    }

    fun buildYouTubeThumbnailURL(key: String): String {
        return "https://img.youtube.com/vi/$key/0.jpg"
    }

    fun buildYoutubeURL(key: String): String {
        return "https://www.youtube.com/watch?v=" + key
    }

    fun buildMovieDetailUrl(movieId: String): String {
        return BASE_URL + movieId + "?api_key=" + API_KEY + "&append_to_response=videos"
    }

    fun buildMovieReviewUrl(movieId: String, pageNumber: Int): String {
        return BASE_URL + movieId + "/reviews?api_key=" + API_KEY +
                "&language=en-US&page="+ pageNumber
    }

    fun buildImdbUrl(id: String):String{
        return "https://www.imdb.com/title/"+id+"/"
    }

    fun buildWikiUrl(name: String):String{
        return "https://en.wikipedia.org/wiki/"+name
    }
}