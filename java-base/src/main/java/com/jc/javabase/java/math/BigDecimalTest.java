package com.jc.javabase.java.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * bigDecimal测试小数保留和四舍五入
 *
 * @author jiancheng
 * @date 2019-10-18
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal untaxedPurchasePrice = new BigDecimal("5.31");
        BigDecimal taxRate = new BigDecimal("0.13");
        BigDecimal purchasingCost = untaxedPurchasePrice.multiply(new BigDecimal(1).add(taxRate));
        System.out.println(purchasingCost);
        purchasingCost = purchasingCost.setScale(2, RoundingMode.HALF_UP);
        System.out.println(purchasingCost);
    }
}
