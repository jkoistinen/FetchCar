package com.example.jk.fetchcar;

import com.example.jk.fetchcar.model.vehicle.Vehicle;
import com.example.jk.fetchcar.network.VehicleAPIService;

import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void test_200() throws IOException {

        MockWebServer mockWebServer = new MockWebServer();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mockWebServer.enqueue(new MockResponse().setBody("{\n" +
                "  \"regno\": \"wur816\",\n" +
                "  \"vin\": \"tmbga61z852094863\",\n" +
                "  \"timestamp\": \"2015-05-29T12:18:31.390Z\",\n" +
                "  \"emission\": {\n" +
                "    \"gasoline\": {\n" +
                "      \"co2\": {\n" +
                "        \"mixed\": 0.000175\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"fuel\": {\n" +
                "    \"gasoline\": {\n" +
                "      \"average_consumption\": {\n" +
                "        \"urban\": 0.000099,\n" +
                "        \"rural\": 0.000058,\n" +
                "        \"mixed\": 0.000073\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"gearbox_type\": \"manual\",\n" +
                "  \"year\": 2005,\n" +
                "  \"brand\": \"volvo\",\n" +
                "  \"fuel_types\": [\n" +
                "    \"gasoline\"\n" +
                "  ]\n" +
                "}"));

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
