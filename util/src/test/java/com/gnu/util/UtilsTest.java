package com.gnu.util;

import org.junit.Test;

import javax.rmi.CORBA.Util;

import static org.junit.Assert.*;

/**
 * Created by xuejiawei on 2017/6/28.
 */
public class UtilsTest {
    @Test
    public void powerOf2() throws Exception {
        boolean result = Utils.powerOf2(8);
        assertEquals(true, result);

        result = Utils.powerOf2(12);
        assertEquals(false, result);
    }

    @Test
    public void nextPowerOf2() throws Exception {
        int result = Utils.nextPowerOf2(0);
        assertEquals(0, result);

        result = Utils.nextPowerOf2(8);
        assertEquals(8, result);

        result = Utils.nextPowerOf2(31);
        assertEquals(32, result);
    }

}