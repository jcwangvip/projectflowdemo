package com.jc.javabase.java.reflect;

import com.jc.javabase.util.DateUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

/**
 * 文件工具类
 *
 * @author jiancheng
 * @date 2019-6-17
 */
public class ClassUtils {


    /**
     * java类对象属性对比
     *
     * @param startObject 开始类
     * @param endObject   结束类
     * @param compareType 对比类型,1.属性值想等的/-1.属性值不相等的
     * @return map 对比结果
     */
    public static Map<String, List<Object>> compare(Object startObject, Object endObject, int compareType) {
        if (null == startObject && null == endObject) {
            return new HashMap<>(16);
        }
        if (null == startObject) {
            startObject = new Object();
        }
        if (null == endObject) {
            endObject = new Object();
        }
        Class<?> beforeClass = startObject.getClass();
        Field[] declaredFields = beforeClass.getDeclaredFields();
        Class<?> afterClass = endObject.getClass();
        Field[] declaredFieldsByAfter = afterClass.getDeclaredFields();
        Map<String, List<Object>> map = new HashMap();
        Object finalStartObject = startObject;
        Object finalEndObject = endObject;
        Arrays.asList(declaredFields).forEach(f -> Stream.of(declaredFieldsByAfter).filter(df -> getField(f, df)).findFirst()
                .ifPresent(x -> getMap(finalStartObject, finalEndObject, compareType, map, f, x)));
        return map;
    }

    private static void getMap(Object startObject, Object endObject, int compareType, Map<String, List<Object>> map, Field f, Field x) {
        f.setAccessible(true);
        x.setAccessible(true);
        try {
            List<Object> list = new ArrayList<>();
            Object o = f.get(startObject);
            Object o1 = x.get(endObject);
            list.add(o);
            list.add(o1);
            if (null == o && null == o1) {
                return;
            }
            if (null == o || null == o1) {
                if (compareType == -1) {
                    map.put(f.getName(), list);
                }
                return;
            }

            System.out.println("f 的" + f.getType().getName() + " " + f.getName() + " = " + o + ",x 的" + x.getType().getName() + " " + x.getName() + " = " + o1);
            if (o instanceof Number) {
                int i = new BigDecimal(o.toString()).compareTo(new BigDecimal(o1.toString()));
                if (compareType == 1) {
                    if (i == 0) {
                        map.put(f.getName(), list);
                    }
                } else if (compareType == -1) {
                    if (i != 0) {
                        map.put(f.getName(), list);
                    }
                }
            } else if (o instanceof String || o instanceof Boolean || o instanceof Enum || o instanceof Collection) {
                if (compareType == 1) {
                    if (o.equals(o1)) {
                        map.put(f.getName(), list);
                    }
                } else if (compareType == -1) {
                    if (!o.equals(o1)) {
                        map.put(f.getName(), list);
                    }
                }
            } else if (o instanceof Date) {
                String date = DateUtils.getDate((Date) o);
                String date1 = DateUtils.getDate((Date) o1);
                if (compareType == 1) {
                    if (date.compareTo(date1) == 0) {
                        map.put(f.getName(), list);
                    }
                } else if (compareType == -1) {
                    if (date.compareTo(date1) != 0) {
                        map.put(f.getName(), list);
                    }
                }
            } else {
                Map<String, List<Object>> compare = compare(o, o1, compareType);
                if (!compare.isEmpty()) {
                    map.put(f.getName(), Collections.singletonList(compare));
                }
            }

        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }


    private static boolean getField(Field f, Field df) {
        return f.getName().equals(df.getName());
    }

}
