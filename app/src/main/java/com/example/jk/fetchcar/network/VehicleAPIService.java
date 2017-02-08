package com.example.jk.fetchcar.network;

import com.example.jk.fetchcar.model.vehicle.Vehicle;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VehicleAPIService {

    @GET("/sommestad/e38c1acf2aed495edf2d/raw/cdb6dfb85101eedad60853c44266249a3f4ac5df/vehicle-attributes.json")
    Call<Vehicle> getVehicle();

}
