package com.jc.javabase.java.lang.number;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-12
 */
@Slf4j
public class BigDecimalDemo {

    public static void main(String[] args) {


        BigDecimal percentage = new BigDecimal(0.51);
        BigDecimal costPrice = new BigDecimal(2);

        BigDecimal a = percentage.divide(costPrice, 2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal a1 = percentage.divide(costPrice, 2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal a2 = percentage.divide(costPrice, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);


        BigDecimal value = new BigDecimal(1);
        BigDecimal subtractValue = value.subtract(percentage);
        BigDecimal price = costPrice.divide(subtractValue, 2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal price1 = costPrice.divide(subtractValue, 2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal price2 = costPrice.divide(subtractValue, 2, BigDecimal.ROUND_HALF_UP);

        System.out.println(price);
        System.out.println(price1);
        System.out.println(price2);

    }


}
