package com.example.jk.fetchcar;

import com.example.jk.fetchcar.model.vehicle.Vehicle;
import com.example.jk.fetchcar.network.VehicleAPIService;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jk on 2017-02-14.
 */

public class MockVehicleAPIService {

    private static final String  ASSET_BASE_PATH = "../app/src/test/java/com/example/jk/fetchcar/assets/";

    private String readJsonFile (String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ASSET_BASE_PATH + filename)));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }

        return sb.toString();
    }

    @Test
    public void test_200() throws IOException {

        MockWebServer mockWebServer = new MockWebServer();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mockWebServer.enqueue(new MockResponse().setBody(readJsonFile("response_200.json")));

        VehicleAPIService service1 = retrofit.create(VehicleAPIService.class);

        Call<Vehicle> vehicle = service1.getVehicle();
        Response<Vehicle> vehicleResponse = vehicle.execute();
        Vehicle vehicleObject = vehicleResponse.body();

        assertEquals(vehicleObject.getRegno(), "wur816");
        assertEquals(StringFormatter.toUpperCase(vehicleObject.getRegno()), "WUR816");

        assertEquals(vehicleObject.getVin(), "tmbga61z852094863");
        assertEquals(StringFormatter.toUpperCase(vehicleObject.getVin()), "TMBGA61Z852094863");

        assertEquals(vehicleObject.getEmission().getGasoline().getCo2().getMixed(), 0.000175);
        assertEquals(StringFormatter.decimalFormat(vehicleObject.getEmission().getGasoline().getCo2().getMixed()), "0.000175");

        mockWebServer.shutdown();
    }

    @Test
    public void test_404() throws IOException {

        MockWebServer mockWebServer = new MockWebServer();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mockWebServer.enqueue(new MockResponse().setResponseCode(404).setBody("Not Found"));

        VehicleAPIService service1 = retrofit.create(VehicleAPIService.class);

        Call<Vehicle> vehicleCall = service1.getVehicle();

        Response<Vehicle> response = vehicleCall.execute();
        assertEquals(response.code(), 404);
        assertEquals(response.message(), "Client Error");

        mockWebServer.shutdown();
    }
}
