package com.example.jk.fetchcar.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jk on 2017-02-03.
 */

public interface CarAPIService {

    @GET("/sommestad/e38c1acf2aed495edf2d/raw/cdb6dfb85101eedad60853c44266249a3f4ac5df/vehicle-attributes.json")
    Call<JsonObject> readJson();

}
