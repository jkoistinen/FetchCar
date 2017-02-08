package com.example.jk.fetchcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jk.fetchcar.model.vehicle.Vehicle;
import com.example.jk.fetchcar.model.vehicle.Co2;
import com.example.jk.fetchcar.model.vehicle.Emission;
import com.example.jk.fetchcar.model.vehicle.Fuel;
import com.example.jk.fetchcar.model.vehicle.Gasoline;
import com.example.jk.fetchcar.network.VehicleAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VehicleAPIService service1 = retrofit.create(VehicleAPIService.class);

        Call<Vehicle> vehicle = service1.getVehicle();

        vehicle.enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {

                Vehicle vehicle = response.body();

                TextView regnoTV = (TextView) findViewById(R.id.regno);
                TextView vinTV = (TextView) findViewById(R.id.vin);
                TextView timestampTV = (TextView) findViewById(R.id.timestamp);
                TextView emissionTV = (TextView) findViewById(R.id.emission);
                TextView fuelTV = (TextView) findViewById(R.id.fuel);
                TextView gearboxtypeTV = (TextView) findViewById(R.id.gearboxtype);

                regnoTV.setText(vehicle.getRegno());
                vinTV.setText(vehicle.getVin());
                timestampTV.setText(vehicle.getTimestamp());

                Emission emission = vehicle.getEmission();
                Gasoline gasoline = emission.getGasoline();
                Co2 co2 = gasoline.getCo2();
                String co2Mixed = Double.toString(co2.getMixed());

                emissionTV.setText(co2Mixed);

                Fuel fuel = vehicle.getFuel();
                String fuelMixed = Double.toString(fuel.getGasoline().getAverageConsumption().getMixed());
                fuelTV.setText(fuelMixed);

                gearboxtypeTV.setText(vehicle.getGearboxType());

            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                //Failure
            }
        });

    }
}
