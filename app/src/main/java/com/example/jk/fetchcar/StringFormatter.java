package com.example.jk.fetchcar;

import java.text.DecimalFormat;

/**
 * Created by jk on 2017-02-08.
 */

public class StringFormatter {

    public static String format(double d)
    {
        DecimalFormat df = new DecimalFormat("##.#######");
        return df.format(d);
    }

}
