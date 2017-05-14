package com.example.android.popularmovieiak.network.retrofit;

import com.example.android.popularmovieiak.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ulfiaizzati on 10/13/16.
 */

public interface IMovieDBNetworkCall {

    final String TMDB_API_KEY = "257daff2ea5e8a52ce59c391d4c07251";

    @GET("popular?api_key="+TMDB_API_KEY)
    Call<Movies> getPopularMovies();

    @GET("top_rated?api_key="+TMDB_API_KEY)
    Call<Movies> getTopRatedMovies();

}
