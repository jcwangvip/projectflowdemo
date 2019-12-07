package com.jc.javabase.java.lang.number;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-14
 */
public class ByteDemo {


    public static void main(String[] args) {

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.TYPE);

        Byte aByte = new Byte("126");
        System.out.println("aByte byte = " + aByte);
        System.out.println("aByte byteValue = " + aByte.byteValue());
        System.out.println("aByte shortValue = " + aByte.shortValue());
        System.out.println("aByte longValue = " + aByte.longValue());
        System.out.println("aByte floatValue = " + aByte.floatValue());
        System.out.println("aByte doubleValue = " + aByte.doubleValue());

    }


}
