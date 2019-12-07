package com.jc.javabase.java.reflect.demo;

import com.jc.javabase.java.reflect.ClassUtils;
import com.jc.javabase.java.reflect.ReflectionDetailVO;
import com.jc.javabase.java.reflect.ReflectionEnum;
import com.jc.javabase.java.reflect.ReflectionVO;
import com.jc.javabase.util.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-22
 */
public class ClassFileUtilsDemo {
    public static void main(String[] args) {
//        System.out.println("testInt.........................");
//        testInt();
//        System.out.println("testInteger.........................");
//        testInteger();
//        System.out.println("testBigDecimal.........................");
//        testBigDecimal();
//        System.out.println("testString.........................");
//        testString();
//        System.out.println("testEnum.........................");
//        testEnum();
//        System.out.println("testObject.........................");
//        testObject();
//        System.out.println("testList.........................");
//        testList();
        System.out.println("testDate.........................");
        testDate();
    }

    private static void testDate() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setTestDate(new Date());

        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setTestDate(DateUtils.getDate());
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testList() {
        ReflectionVO reflectionVO = new ReflectionVO();
        List<ReflectionDetailVO> listReflectionDetailVO = new ArrayList<>();
        ReflectionDetailVO reflectionDetailVO = new ReflectionDetailVO();
        reflectionDetailVO.setTestInt(1);
        listReflectionDetailVO.add(reflectionDetailVO);
        reflectionVO.setReflectionDetailVOList(listReflectionDetailVO);

        ReflectionVO reflectionVO1 = new ReflectionVO();
        List<ReflectionDetailVO> listReflectionDetailVO1 = new ArrayList<>();
        ReflectionDetailVO reflectionDetailVO1 = new ReflectionDetailVO();
        reflectionDetailVO1.setTestInt(1);
        listReflectionDetailVO1.add(reflectionDetailVO1);
        reflectionVO1.setReflectionDetailVOList(listReflectionDetailVO1);
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testObject() {
        ReflectionVO reflectionVO = new ReflectionVO();
        ReflectionDetailVO reflectionDetailVO = new ReflectionDetailVO();
        reflectionDetailVO.setTestInt(1);
        reflectionVO.setReflectionDetailVO(reflectionDetailVO);

        ReflectionVO reflectionVO1 = new ReflectionVO();
        ReflectionDetailVO reflectionDetailVO1 = new ReflectionDetailVO();
        reflectionDetailVO1.setTestInt(1);
        reflectionVO1.setReflectionDetailVO(reflectionDetailVO1);
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testEnum() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setReflectionEnum(ReflectionEnum.NAME);
        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setReflectionEnum(ReflectionEnum.NAME);
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }


    private static void testString() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setTestString("1");
        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setTestString("1");
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testBigDecimal() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setTestBigDecimal(new BigDecimal("1.00"));
        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setTestBigDecimal(new BigDecimal("1"));
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testInteger() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setTestInteger(new Integer(1));
        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setTestInteger(new Integer(1));
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }

    private static void testInt() {
        ReflectionVO reflectionVO = new ReflectionVO();
        reflectionVO.setTestInt(1);
        ReflectionVO reflectionVO1 = new ReflectionVO();
        reflectionVO1.setTestInt(1);
        Map<String, List<Object>> compare = ClassUtils.compare(reflectionVO, reflectionVO1, -1);
        System.out.println(compare);
    }
}
