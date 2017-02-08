package com.example.jk.fetchcar.model.vehicle;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gasoline {

    @SerializedName("co2")
    @Expose
    private Co2 co2;

    public Co2 getCo2() {
        return co2;
    }

    public void setCo2(Co2 co2) {
        this.co2 = co2;
    }

}