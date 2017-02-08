package com.example.jk.fetchcar.model.vehicle;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Vehicle {

    @SerializedName("regno")
    @Expose
    private String regno;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("emission")
    @Expose
    private Emission emission;
    @SerializedName("fuel")
    @Expose
    private Fuel fuel;
    @SerializedName("gearbox_type")
    @Expose
    private String gearboxType;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("fuel_types")
    @Expose
    private List<String> fuelTypes = null;

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Emission getEmission() {
        return emission;
    }

    public void setEmission(Emission emission) {
        this.emission = emission;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(List<String> fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

}
