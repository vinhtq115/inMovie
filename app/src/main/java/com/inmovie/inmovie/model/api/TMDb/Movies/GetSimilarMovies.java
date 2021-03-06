package com.inmovie.inmovie.model.api.TMDb.Movies;

import android.os.AsyncTask;

import com.inmovie.inmovie.Adapters.TrendingsAdapter;
import com.inmovie.inmovie.BuildConfig;
import com.inmovie.inmovie.MovieTvClasses.Movies;
import com.inmovie.inmovie.model.api.Network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetSimilarMovies extends AsyncTask<Integer, Void, JSONObject> {
    private int page;
    private TrendingsAdapter adapter;

    public GetSimilarMovies() {
        page = 1;
    }

    public GetSimilarMovies(TrendingsAdapter adapter){
        this.adapter = adapter;
        page = 1;
    }

    public GetSimilarMovies(int page) {
        this.page = page;
    }

    @Override
    protected JSONObject doInBackground(Integer... integers) {
        JSONObject result = Network.getJSONObject("https://api.themoviedb.org/3/movie/" + integers[0] + "/similar?api_key=" + BuildConfig.TMDb_API_key  + "&page=" + page);

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject){
        try{
            ArrayList<Movies> moviesArrayList = new ArrayList<>();
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            JSONObject movieJSON = null;
            for(int i = 0; i < jsonArray.length(); i++){
                Movies m = new Movies();
                movieJSON = jsonArray.getJSONObject(i);
                Movies movies = new Movies();
                String poster_url = movieJSON.getString("poster_path");
                String backdrop_url = movieJSON.getString("backdrop_path");
                String name = movieJSON.getString("title");
                String releaseDate = movieJSON.getString("release_date");
                int id = movieJSON.getInt("id");

                movies.setId(id);
                movies.setPoster(poster_url);
                movies.setBackdrop(backdrop_url);
                movies.setTitle(name);
                movies.setReleaseDate(releaseDate);
                moviesArrayList.add(movies);
            }
            adapter.setMoviesList(moviesArrayList, true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
