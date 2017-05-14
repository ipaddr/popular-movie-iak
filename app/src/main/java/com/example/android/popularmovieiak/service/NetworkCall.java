package com.example.android.popularmovieiak.service;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.example.android.popularmovieiak.model.Movies;
import com.example.android.popularmovieiak.network.retrofit.IMovieDBNetworkCall;
import com.example.android.popularmovieiak.network.retrofit.MovieDBNetworkCall;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NetworkCall extends IntentService {

    private static final String TAG = NetworkCall.class.getSimpleName();

    public static final String ACTION_CALL_API_POPULAR_MOVIE = "ACTION_CALL_API_POPULAR_MOVIE";

    public NetworkCall() {
        super("NetworkCall");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent.getAction() != null && !TextUtils.isEmpty(intent.getAction())){
            String action = intent.getAction();
            if (action.equals(ACTION_CALL_API_POPULAR_MOVIE)){
                handleActionGetPopularMovies();
            }
        }
    }

    private void handleActionGetPopularMovies() {
        IMovieDBNetworkCall callMovieAPI = MovieDBNetworkCall.getCalledMoviesAPI();
        Call<Movies> callPopularMovies = callMovieAPI.getPopularMovies();
        try {
            Movies movies = callPopularMovies.execute().body();
            Log.d(TAG, "size : "+ movies.getMovies().size());
            EventBus.getDefault().post(movies);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
