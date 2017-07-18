package com.gnu.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xuejiawei on 2017/6/28.
 */
public class NumberUtilTest {
    @Test
    public void powerOf2() throws Exception {
        boolean result = NumberUtil.powerOf2(8);
        assertEquals(true, result);

        result = NumberUtil.powerOf2(12);
        assertEquals(false, result);
    }

    @Test
    public void nextPowerOf2() throws Exception {
        int result = NumberUtil.nextPowerOf2(0);
        assertEquals(0, result);

        result = NumberUtil.nextPowerOf2(8);
        assertEquals(8, result);

        result = NumberUtil.nextPowerOf2(31);
        assertEquals(32, result);
    }

}