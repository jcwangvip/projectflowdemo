package com.jc.javabase.java.lang.number;

import lombok.extern.slf4j.Slf4j;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-12
 */
@Slf4j
public class NumberDemo {

    public static void main(String[] args) {

        NumberDemo.compare(1, 1);
        NumberDemo.compare(144.00,144.0000);
//        BigDecimal percentage = new BigDecimal("0.02");
//        BigDecimal costPrice = new BigDecimal("5000");

//        BigDecimal percentage = new BigDecimal(0.03);
//        BigDecimal costPrice = new BigDecimal(5000);

    }


    private static void compare(Object o, Object o1) {
        System.out.println("o.equals(o1) = " + o.equals(o1));

        if (o instanceof Number) {
            Number n = (Number) o;
            double value = n.doubleValue();
            System.out.println(value);

            Number n1 = (Number) o1;
            double value1 = n1.doubleValue();
            System.out.println(value1);

            Double d = new Double(23434324234234.34234234234324323);
            System.out.println(d);
            System.out.println(d.intValue());

            System.out.println("value = value1 -> " + (value == value1));
        }

    }
}
