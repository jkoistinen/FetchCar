package com.example.jk.fetchcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jk.fetchcar.model.car.Car;
import com.example.jk.fetchcar.model.car.Co2;
import com.example.jk.fetchcar.model.car.Emission;
import com.example.jk.fetchcar.model.car.Fuel;
import com.example.jk.fetchcar.model.car.Gasoline;
import com.example.jk.fetchcar.network.CarAPIService;

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

        CarAPIService service1 = retrofit.create(CarAPIService.class);

        Call<Car> car = service1.getCar();

        car.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {

                Car car = response.body();

                TextView regnoTV = (TextView) findViewById(R.id.regno);
                TextView vinTV = (TextView) findViewById(R.id.vin);
                TextView timestampTV = (TextView) findViewById(R.id.timestamp);
                TextView emissionTV = (TextView) findViewById(R.id.emission);
                TextView fuelTV = (TextView) findViewById(R.id.fuel);
                TextView gearboxtypeTV = (TextView) findViewById(R.id.gearboxtype);

                regnoTV.setText(car.getRegno());
                vinTV.setText(car.getVin());
                timestampTV.setText(car.getTimestamp());

                Emission emission = car.getEmission();
                Gasoline gasoline = emission.getGasoline();
                Co2 co2 = gasoline.getCo2();
                String co2Mixed = Double.toString(co2.getMixed());

                emissionTV.setText(co2Mixed);

                Fuel fuel = car.getFuel();
                String fuelMixed = Double.toString(fuel.getGasoline().getAverageConsumption().getMixed());
                fuelTV.setText(fuelMixed);

                gearboxtypeTV.setText(car.getGearboxType());

            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                //Failure
            }
        });

    }
}
