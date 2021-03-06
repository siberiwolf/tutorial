package com.gnu.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by siberiwolf@hotmail.com on 2017/7/18.
 */
public class TimeUtilTest {
    @Test
    public void checkSameDay() throws Exception {
        boolean result = TimeUtil.checkSameDay(System.currentTimeMillis(), System.currentTimeMillis());
        assertEquals(result, true);

        result = TimeUtil.checkSameDay(System.currentTimeMillis(), 0);
        assertEquals(result, false);
    }

}