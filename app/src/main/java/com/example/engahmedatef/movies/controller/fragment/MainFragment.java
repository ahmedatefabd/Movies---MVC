package com.example.engahmedatef.movies.controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.engahmedatef.movies.R;
import com.example.engahmedatef.movies.adapter.MovieAdapter;
import com.example.engahmedatef.movies.api.Networking;
import com.example.engahmedatef.movies.callback.OnMoviesReterivalListener;
import com.example.engahmedatef.movies.model.Movie;
import com.example.engahmedatef.movies.util.Connection;
import com.example.engahmedatef.movies.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private MovieAdapter adapter;// referance --> class_Adapter


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);
            }
        });

        if (Connection.isNetworkAvailable(getActivity())) {
            downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
        } else {
            lodeFromCache();
        }
        return view;
    }

    private void lodeFromCache() {

        List<Movie> cachedPopular = FastSave.getInstance().getObjectsList(Constant.EXTRA.POPULAR_MOVIES_CACHED, Movie.class);

        List<Movie> cachedTopRated = FastSave.getInstance().getObjectsList(Constant.EXTRA.TOP_RATED_MOVIES_CACHED, Movie.class);

        if (cachedPopular.size() < 0) {

            adapter = new MovieAdapter(getActivity(), cachedPopular);
            recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recycler.setAdapter(adapter);

        } else if (cachedTopRated.size() < 0) {

            adapter = new MovieAdapter(getActivity(), cachedTopRated);
            recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recycler.setAdapter(adapter);

        } else {

            Toast.makeText(getActivity(), "No Cached Data", Toast.LENGTH_SHORT).show();
            adapter = new MovieAdapter(getActivity() , new ArrayList<Movie>());
            recycler.setAdapter(adapter);
        }
    }


    // Method download Movies by Library-->Fastnetwark
    private void downloadMovies(final String moviesTypes) {
        progressBar.setVisibility(View.VISIBLE);

        Networking.getMovies(moviesTypes, new OnMoviesReterivalListener() {
            @Override
            public void onSucess(List<Movie> movieList) {

                progressBar.setVisibility(View.INVISIBLE);

                recyclerView(movieList);

                if (swiperefreshlayout.isRefreshing()){

                    swiperefreshlayout.setRefreshing(false);
                }

                if (moviesTypes.equals(Constant.Api.POPULAR_MOVIES_KEY)) {

                    FastSave.getInstance().saveObjectsList(Constant.EXTRA.POPULAR_MOVIES_CACHED, movieList);

                } else {

                    FastSave.getInstance().saveObjectsList(Constant.EXTRA.TOP_RATED_MOVIES_CACHED, movieList);
                }
            }

            @Override
            public void onError(String errorMsg) {

                progressBar.setVisibility(View.INVISIBLE);

                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();

                swiperefreshlayout.setRefreshing(false);

            }
        });
    }

    // Method Recycler & Adapter
    public void recyclerView(List<Movie> movieList) {

        adapter = new MovieAdapter(getActivity(), movieList);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main_activity, menu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.popular:
                downloadMovies(Constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
//                return true;
                break;

            case R.id.top_rated:
                if (Connection.isNetworkAvailable(getActivity())) {

                    downloadMovies(Constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark

                } else {
                    lodeFromCache();
                }

                break;

            case R.id.favorite:

                List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.EXTRA.FAV_MOVIES, Movie.class);
                adapter = new MovieAdapter(getActivity(), movies);
                recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                recycler.setAdapter(adapter);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
