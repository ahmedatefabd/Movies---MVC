package com.example.engahmedatef.movies.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.engahmedatef.movies.R;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.recycler)
//    RecyclerView recycler;
//    @BindView(R.id.progress_bar)
//    ProgressBar progressBar;
//    @BindView(R.id.swiperefreshlayout)
//    SwipeRefreshLayout swiperefreshlayout;
//
//   private MovieAdapter adapter;// referance --> class_Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);
//            }
//        });
//
//        if (Connection.isNetworkAvailable(this)) {
//            downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
//        } else {
//            lodeFromCache();
//        }
//
//    }
//
//    private void lodeFromCache() {
//
//        List<Movie> cachedPopular = FastSave.getInstance().getObjectsList(Constant.EXTRA.POPULAR_MOVIES_CACHED, Movie.class);
//
//        List<Movie> cachedTopRated = FastSave.getInstance().getObjectsList(Constant.EXTRA.TOP_RATED_MOVIES_CACHED, Movie.class);
//
//        if (cachedPopular.size() < 0) {
//
//            adapter = new MovieAdapter(MainActivity.this, cachedPopular);
//            recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//            recycler.setAdapter(adapter);
//
//        } else if (cachedTopRated.size() < 0) {
//
//            adapter = new MovieAdapter(MainActivity.this, cachedTopRated);
//            recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//            recycler.setAdapter(adapter);
//
//        } else {
//
//            Toast.makeText(this, "No Cached Data", Toast.LENGTH_SHORT).show();
//            adapter = new MovieAdapter(MainActivity.this , new ArrayList<Movie>());
//            recycler.setAdapter(adapter);
//        }
//    }
//
//
//    // Method download Movies by Library-->Fastnetwark
//    private void downloadMovies(final String moviesTypes) {
//        progressBar.setVisibility(View.VISIBLE);
//
//        Networking.getMovies(moviesTypes, new OnMoviesReterivalListener() {
//            @Override
//            public void onSucess(List<Movie> movieList) {
//
//                progressBar.setVisibility(View.INVISIBLE);
//
//                recyclerView(movieList);
//
//                if (swiperefreshlayout.isRefreshing()){
//                    swiperefreshlayout.setRefreshing(false);
//                }
//
//                if (moviesTypes.equals(Constant.Api.POPULAR_MOVIES_KEY)) {
//                    FastSave.getInstance().saveObjectsList(Constant.EXTRA.POPULAR_MOVIES_CACHED, movieList);
//                } else {
//                    FastSave.getInstance().saveObjectsList(Constant.EXTRA.TOP_RATED_MOVIES_CACHED, movieList);
//                }
//            }
//
//            @Override
//            public void onError(String errorMsg) {
//
//                progressBar.setVisibility(View.INVISIBLE);
//
//                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
//
//                swiperefreshlayout.setRefreshing(false);
//
//            }
//        });
//    }
//
//    // Method Recycler & Adapter
//    public void recyclerView(List<Movie> movieList) {
//
//        adapter = new MovieAdapter(MainActivity.this, movieList);
//        recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//        recycler.setAdapter(adapter);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//
//            case R.id.popular:
//                downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
////                return true;
//                break;
//
//            case R.id.top_rated:
//                if (Connection.isNetworkAvailable(this)) {
//
//                    downloadMovies(Constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
//                } else {
//                    lodeFromCache();
//                }
//
//                break;
//
//            case R.id.favorite:
//
//                List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.EXTRA.FAV_MOVIES, Movie.class);
//                adapter = new MovieAdapter(MainActivity.this, movies);
//                recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//                recycler.setAdapter(adapter);
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
    }
}

