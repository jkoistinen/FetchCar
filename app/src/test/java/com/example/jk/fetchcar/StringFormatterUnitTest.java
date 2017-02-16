package com.example.jk.fetchcar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StringFormatterUnitTest {
    @Test
    public void toDecimalFormat_isCorrect() throws Exception {
        double d = 0.000175;
        String result = "0.000175";
        assertEquals(result, StringFormatter.toDecimalFormat(d));
    }

    @Test
    public void toUpperCase_isCorrect() throws Exception {
        String s = "test123";
        String result = "TEST123";
        assertEquals(result, StringFormatter.toUpperCase(s));
    }
}