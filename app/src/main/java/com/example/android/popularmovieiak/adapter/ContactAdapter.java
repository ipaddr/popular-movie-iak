package com.example.android.popularmovieiak.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovieiak.R;
import com.example.android.popularmovieiak.model.Movie;
import com.example.android.popularmovieiak.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends
        RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public ContactAdapter(Context context, List<Movie> movies){
        super();
        this.context = context;
        this.movies = new ArrayList<>();
        if (movies != null)
            this.movies.addAll(movies);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.row_poster, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        String url = "http://image.tmdb.org/t/p/w185/" + movie.getPosterPath();
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.hp)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
