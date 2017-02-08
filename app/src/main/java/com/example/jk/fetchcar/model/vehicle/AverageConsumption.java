package com.example.jk.fetchcar.model.vehicle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 2017-02-03.
 */

public class AverageConsumption {

    @SerializedName("urban")
    @Expose
    private Double urban;
    @SerializedName("rural")
    @Expose
    private Double rural;
    @SerializedName("mixed")
    @Expose
    private Double mixed;

    public Double getUrban() {
        return urban;
    }

    public void setUrban(Double urban) {
        this.urban = urban;
    }

    public Double getRural() {
        return rural;
    }

    public void setRural(Double rural) {
        this.rural = rural;
    }

    public Double getMixed() {
        return mixed;
    }

    public void setMixed(Double mixed) {
        this.mixed = mixed;
    }

}