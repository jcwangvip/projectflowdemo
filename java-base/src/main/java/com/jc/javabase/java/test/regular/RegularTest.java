package com.jc.javabase.java.test.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则判断的字符串是否含有特殊字符
 *
 * @author jiancheng
 * @date 2019-10-11
 */
public class RegularTest {

    public static void main(String[] args) {
//        String str = "判断的字符串T490-20N000058C，,（）/()D";
//        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

//        String str = "判断的字符串，（）()/";
//        String regEx = "[`~!@#$%^&*+=|{}':;'\\[\\].<>?~！@#￥%……&*——+|{}【】‘；：’。、？]";
//
//        String str = "判断的字符串2";
//        String regEx = "^[\\u4e00-\\u9fa5]{0,}$";

        String str = "123abc";
        String regEx = "/^[0-9]+abc$/";

        test(str, regEx);
    }

    private static void test(String str, String regEx) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println(m.find());
    }

}
