package com.example.countries.Data;

import com.example.countries.Model.Root;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostInterface {
    @GET("rest/?method=flickr.photos.search&format=json&nojsoncallback=50&text=Color&page=1&api_key=d17378e37e555ebef55ab86c4180e8dc")
    Observable<Root> getPosts(@Query("per_page") Integer per_page);
}
