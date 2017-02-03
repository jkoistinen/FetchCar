package com.example.jk.fetchcar.model.car;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gasoline_ {

    @SerializedName("average_consumption")
    @Expose
    private AverageConsumption averageConsumption;

    public AverageConsumption getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(AverageConsumption averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

}
