package com.jc.javabase.java.lang.number;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-14
 */
public class Literals {


    public static void main(String[] args) {
        char c = 0xffff; // max char hex value
        byte b = 0x7f; // max byte hex value
        short s = 0x7fff; // max short hex value
        int i1 = 0x2f; // Hexadecimal (lowercase)
        int i2 = 0X2F; // Hexadecimal (uppercase)
        int i3 = 0177; // Octal (leading zero)   // Hex and Oct also work with long.
        long n1 = 200L; // long suffix
        long n2 = 200l; // long suffix
        long n3 = 200;   //! long l6(200); // not allowed
        float f1 = 1;
        float f2 = 1F; // float suffix
        float f3 = 1f; // float suffix
        float f4 = 1e-45f; // 10 to the power
        float f5 = 1e+9f; // float suffix
        double d1 = 1d; // double suffix
        double d2 = 1D; // double suffix
        double d3 = 47e47d; // 10 to the power

        System.out.println("char c =" + c);
        System.out.println("byte b =" + b);
        System.out.println("short s =" + s);
        System.out.println("int i1 =" + i1);
        System.out.println("int i2 =" + i2);
        System.out.println("int i3 =" + i3);
        System.out.println("long n1 =" + n1);
        System.out.println("long n2 =" + n2);
        System.out.println("long n3 =" + n3);
        System.out.println("float f1 =" + f1);
        System.out.println("float f2 =" + f2);
        System.out.println("float f3 =" + f3);
        System.out.println("float f4 =" + f4);
        System.out.println("float f5 =" + f5);
        System.out.println("double d1 =" + d1);
        System.out.println("double d2 =" + d2);
        System.out.println("double d3 =" + d3);


    }

}
