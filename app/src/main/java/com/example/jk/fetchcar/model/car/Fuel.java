package com.example.jk.fetchcar.model.car;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fuel {

    @SerializedName("gasoline")
    @Expose
    private Gasoline_ gasoline;

    public Gasoline_ getGasoline() {
        return gasoline;
    }

    public void setGasoline(Gasoline_ gasoline) {
        this.gasoline = gasoline;
    }

}
