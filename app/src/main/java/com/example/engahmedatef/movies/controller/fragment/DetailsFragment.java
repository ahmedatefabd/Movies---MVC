package com.example.engahmedatef.movies.controller.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmedatef.movies.R;
import com.example.engahmedatef.movies.controller.activity.Trailers_Activity;
import com.example.engahmedatef.movies.model.Movie;
import com.example.engahmedatef.movies.util.Constant;
import com.example.engahmedatef.movies.util.FormatDate;
import com.example.engahmedatef.movies.util.Util;
import com.mindorks.nybus.NYBus;
import com.mindorks.nybus.annotation.Subscribe;
import com.mindorks.nybus.event.Channel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    @BindView(R.id.cover_img)
    ImageView coverImg;
    @BindView(R.id.poster_img)
    ImageView posterImg;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_rating)
    TextView movieRating;
    @BindView(R.id.movie_release_date)
    TextView movieReleaseDate;
    @BindView(R.id.btn_Fav)
    FloatingActionButton btnFav;
    @BindView(R.id.movie_description)
    TextView movieDescription;
    @BindView(R.id.movie_trailers_btn)
    Button movieTrailersBtn;


    private Movie mMovie;
//    int id = Integer.parseInt(mMovie.getId());

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        ButterKnife.bind(this, view);

        init();

        NYBus.get().register(this , Channel.ONE);

        return view;
    }

    private void init() {

        if ( ! getActivity().getResources().getBoolean(R.bool.isLand)){// // if portrait no tablet

            Bundle intent = getActivity().getIntent().getExtras();
            final Movie movie = intent.getParcelable(Constant.EXTRA.MOVIE);

            loading(movie);
        }

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isFsv = Util.isFavorite(mMovie.getId());

                if (isFsv)
                {
                    removeMovie();
                }
                else
                {
                    addMovie(mMovie);
                }
            }

            private void removeMovie() {
                Util.removeFavorite(mMovie.getId());
                btnFav.setImageResource(R.drawable.star);
            }

            private void addMovie(Movie m) {
                Util.addFavorite(m);
                btnFav.setImageResource(R.drawable.fav);
            }
        });
    }

    private void loading(final Movie movie) {

        mMovie = movie;

        boolean isFsv = Util.isFavorite(mMovie.getId());

        if (isFsv) {
            btnFav.setImageResource(R.drawable.fav);
        } else {
            btnFav.setImageResource(R.drawable.star);
        }

        Picasso.get()
                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
                .into(posterImg);

        Picasso.get()
                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
                .into(coverImg);

        movieTitle.setText("Title : " + movie.getTitle());
        movieRating.setText("Rating : " + movie.getVoteAverage());

        //formatDate()-->static method is used for change the date format ("yyyy-MM-dd") to ("dd-MM-yyyy")
        //formatDate()-->static method is inside Class-->(FormatDate) inside package-->(util)
        movieReleaseDate.setText("FormatDate : " + FormatDate.formatDate(movie.getReleaseDate()));
        movieDescription.setText("Description : " + movie.getOverview());


        movieTrailersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getActivity(), Trailers_Activity.class);

                intent1.putExtra(Constant.EXTRA.ID_MOVIE, movie.getId());

                startActivity(intent1);
            }
        });


    }

    @Subscribe(channelId = Channel.ONE)
    public void onGitMovie (Movie mMovie) {

        loading(mMovie);
    }

}
