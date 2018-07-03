package com.example.engahmedatef.movies.util;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.engahmedatef.movies.model.Movie;

import java.util.List;

public class Util {

    private Movie movie ;

    public static boolean isFavorite(int id){

        List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.EXTRA.FAV_MOVIES , Movie.class);

        for (Movie m : movies)
        {
            if (m.getId() == id )
            {
                return true;
            }
        }
        return false;
    }

    public static void removeFavorite(int id){

        List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.EXTRA.FAV_MOVIES , Movie.class);

        for (int i = 0; i <movies.size() ; i++) {
            if (movies.get(i).getId() == id){
                movies.remove(i);
                FastSave.getInstance().saveObjectsList(Constant.EXTRA.FAV_MOVIES,movies);
            }
        }
    }

    public static void addFavorite(Movie movie){
        List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.EXTRA.FAV_MOVIES , Movie.class);

        movies.add(movie);
        FastSave.getInstance().saveObjectsList(Constant.EXTRA.FAV_MOVIES,movies);
    }


}
