package com.gnu.util;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by xuejiawei on 2017/7/18.
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