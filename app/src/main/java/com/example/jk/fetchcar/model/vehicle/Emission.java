package com.example.jk.fetchcar.model.vehicle;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Emission {

    @SerializedName("gasoline")
    @Expose
    private Gasoline gasoline;

    public Gasoline getGasoline() {
        return gasoline;
    }

    public void setGasoline(Gasoline gasoline) {
        this.gasoline = gasoline;
    }

}
