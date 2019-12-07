package com.jc.javabase.java8.java.util.function;

import java.util.function.BiFunction;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-12-6
 */
public class BiFunctionDemo {

    public static void main(String[] args) {
        BiFunctionDemo demo = new BiFunctionDemo();
        demo.demo();
    }

    private void demo() {
        BiFunction<Integer, Long, Double> function = (integer, aLong) -> new Double(aLong);
        Double result = function.apply(1, 2L);
        System.out.println(result);
    }
}
