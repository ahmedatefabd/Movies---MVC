package com.example.engahmedatef.movies.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.appizona.yehiahd.fastsave.FastSave;
import com.example.engahmedatef.movies.util.Constant;

import java.util.ArrayList;

public class MoviesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
        FastSave.init(getApplicationContext());

//__________________________________________________________________________________________________________________

        //save Favorite by SharedPreferance
        if (!FastSave.getInstance().isKeyExists(Constant.EXTRA.FAV_MOVIES))
        FastSave.getInstance().saveObjectsList(Constant.EXTRA.FAV_MOVIES , new ArrayList<>());

//__________________________________________________________________________________________________________________

        //save internal app by SharedPreferance  POPULAR_MOVIES_CACHED
        //_____________________________________________________________
        if (!FastSave.getInstance().isKeyExists(Constant.EXTRA.POPULAR_MOVIES_CACHED))
        FastSave.getInstance().saveObjectsList(Constant.EXTRA.POPULAR_MOVIES_CACHED , new ArrayList<>());

//__________________________________________________________________________________________________________________

        //save internal app by SharedPreferance  TOP_RATED_MOVIES_CACHED
        //_______________________________________________________________
        if (!FastSave.getInstance().isKeyExists(Constant.EXTRA.TOP_RATED_MOVIES_CACHED))
        FastSave.getInstance().saveObjectsList(Constant.EXTRA.TOP_RATED_MOVIES_CACHED , new ArrayList<>());

    }
}
