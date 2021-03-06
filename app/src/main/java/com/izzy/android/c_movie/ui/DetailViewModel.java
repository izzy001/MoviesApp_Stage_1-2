package com.izzy.android.c_movie.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import com.izzy.android.c_movie.database.MovieRepository;
import com.izzy.android.c_movie.model.Movie.Movie;
import com.izzy.android.c_movie.model.Review.Review;
import com.izzy.android.c_movie.model.Trailer.Trailer;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private MovieRepository mRepository;
    private LiveData<List<Review>> mReviews;
    private LiveData<List<Trailer>> mTrailers;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        mRepository = new MovieRepository(application);
    }

    public LiveData<List<Review>> getReviews(int id, String apiKey) {
        return mRepository.getReviews(id, apiKey);
    }

    public LiveData<List<Trailer>> getTrailers(int id, String apiKey) {
        return mRepository.getTrailers(id, apiKey);
    }

    public void saveMovie(Movie movie) {
        mRepository.insert(movie);
    }

    public void deleteMovie(Movie movie) {
        mRepository.delete(movie);
    }

    public LiveData<Movie> loadFavById(int id) {
        return mRepository.getMovieById(id);
    }

}
