package com.example.engahmedatef.movies.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.engahmedatef.movies.R;
import com.example.engahmedatef.movies.adapter.TrailerAdapter;
import com.example.engahmedatef.movies.model.ResponseTrailers;
import com.example.engahmedatef.movies.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Trailers_Activity extends AppCompatActivity {

    @BindView(R.id.trailers_recycler)
    RecyclerView trailersRecycler;
    @BindView(R.id.trailers_progressBar)
    ProgressBar trailersProgressBar;

    private TrailerAdapter adapter ;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailers_);
        ButterKnife.bind(this);

        //        Bundle intent = getIntent().getExtras();

        id = getIntent().getExtras().getInt(Constant.EXTRA.ID_MOVIE);

        loadTrailer(id);

    }

    private void loadTrailer(int id) {

        trailersProgressBar.setVisibility(View.VISIBLE);

        AndroidNetworking.get(Constant.Api.BASE_URL + Constant.Api.MOVIE_GET_VIDEO_LINK)
                .addQueryParameter( Constant.Api.TOKEN_NAME , Constant.Api.TOKEN_VALUE )
                .addPathParameter( Constant.Api.KEY_ID_GET_VIDEO , String.valueOf(id))
                .build()
                .getAsObject(ResponseTrailers.class, new ParsedRequestListener<ResponseTrailers>() {

                    @Override
                    public void onResponse(ResponseTrailers response) {

                        trailersProgressBar.setVisibility(View.GONE);

                        RecyclerTrailer(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                        trailersProgressBar.setVisibility(View.GONE);

                        Toast.makeText(Trailers_Activity.this, "anError" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void RecyclerTrailer(ResponseTrailers response) {

        adapter = new TrailerAdapter(Trailers_Activity.this , response.getTrailes());
        trailersRecycler.setLayoutManager(new LinearLayoutManager(Trailers_Activity.this));
        trailersRecycler.setAdapter(adapter);
    }
}
