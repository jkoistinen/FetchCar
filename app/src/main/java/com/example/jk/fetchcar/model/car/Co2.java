package com.example.jk.fetchcar.model.car;

/**
 * Created by jk on 2017-02-03.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Co2 {

    @SerializedName("mixed")
    @Expose
    private Double mixed;

    public Double getMixed() {
        return mixed;
    }

    public void setMixed(Double mixed) {
        this.mixed = mixed;
    }

}
