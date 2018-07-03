package com.example.engahmedatef.movies.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.engahmedatef.movies.R;

import butterknife.ButterKnife;

public class Details_Activity extends AppCompatActivity {

//    @BindView(R.id.cover_img)
//    ImageView coverImg;
//    @BindView(R.id.poster_img)
//    ImageView posterImg;
//    @BindView(R.id.movie_title)
//    TextView movieTitle;
//    @BindView(R.id.movie_rating)
//    TextView movieRating;
//    @BindView(R.id.movie_release_date)
//    TextView movieReleaseDate;
//    @BindView(R.id.movie_description)
//    TextView movieDescription;
//    @BindView(R.id.movie_trailers_btn)
//    Button movieTrailersBtn;
//    @BindView(R.id.btn_Fav)
//    FloatingActionButton Fav_btn;
//
//    private Movie mMovie;
////    int id = Integer.parseInt(mMovie.getId());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        ButterKnife.bind(this);

//        Bundle intent = getIntent().getExtras();
//
//        final Movie movie = intent.getParcelable(Constant.EXTRA.MOVIE);
//        mMovie = movie;
//
//        boolean isFsv = Util.isFavorite(mMovie.getId());
//
//        if (isFsv) {
//            Fav_btn.setImageResource(R.drawable.fav);
//        } else {
//            Fav_btn.setImageResource(R.drawable.star);
//        }
//
//        Picasso.get()
//                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
//                .into(posterImg);
//
//        Picasso.get()
//                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
//                .into(coverImg);
//
//        movieTitle.setText("Title : " + movie.getTitle());
//        movieRating.setText("Rating : " + movie.getVoteAverage());
//
//        //formatDate()-->static method is used for change the date format ("yyyy-MM-dd") to ("dd-MM-yyyy")
//        //formatDate()-->static method is inside Class-->(FormatDate) inside package-->(util)
//        movieReleaseDate.setText("FormatDate : " + FormatDate.formatDate(movie.getReleaseDate()));
//        movieDescription.setText("Description : " + movie.getOverview());
//        movieTrailersBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent1 = new Intent(Details_Activity.this, Trailers_Activity.class);
//
//                intent1.putExtra(Constant.EXTRA.ID_MOVIE, movie.getId());
//
//                startActivity(intent1);
//            }
//        });
//
//
//
//        Fav_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                boolean isFsv = Util.isFavorite(mMovie.getId());
//
//                if (isFsv)
//                {
//                    removeMovie();
//                }
//                else
//                    {
//                        addMovie(mMovie);
//                }
//            }
//
//            private void removeMovie() {
//                Util.removeFavorite(mMovie.getId());
//                Fav_btn.setImageResource(R.drawable.star);
//            }
//
//            private void addMovie(Movie m) {
//                Util.addFavorite(m);
//                Fav_btn.setImageResource(R.drawable.fav);
//            }
//        });

    }

}

