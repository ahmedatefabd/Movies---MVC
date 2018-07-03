package com.example.engahmedatef.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTrailers {
//
//    private String id;
//
//    @SerializedName("results")
//    private List<Trailer> trailes;
//
//    public String getId ()
//    {
//        return id;
//    }
//
//    public void setId (String id)
//    {
//        this.id = id;
//    }
//
//    public List<Trailer> getTrailes() {
//        return trailes;
//    }
//
//    public void setTrailes(List<Trailer> trailes) {
//        this.trailes = trailes;
//    }



    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("results")
    @Expose
    private List<Trailer> trailes = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Trailer> getTrailes() {
        return trailes;
    }

    public void setTrailes(List<Trailer> trailes) {
        this.trailes = trailes;
    }
}
