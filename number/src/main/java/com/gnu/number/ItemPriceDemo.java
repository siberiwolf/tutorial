package com.gnu.number;

import java.math.BigDecimal;

/**
 * double用来做商品价格，不是很准确
 * @author siberiwolf@hotmail.com on 2017/9/28
 */
public class ItemPriceDemo {
    public static void main(String[] args) {
        double priceA = 0.03;
        double priceB = 0.02;
        double diff = priceA - priceB;
        // diff is 0.009999999999999998
        System.out.println(diff);

        // new出来的也不行，结果也是0.009999999999999998
//        BigDecimal priceC = new BigDecimal(0.03);
        BigDecimal priceC = BigDecimal.valueOf(0.03);
        BigDecimal priceD = BigDecimal.valueOf(0.02);
        BigDecimal temp = priceC.subtract(priceD);
        System.out.println(temp.doubleValue());
    }
}
