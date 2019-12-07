package com.jc.javabase.java.reflect;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 反射测试对象
 *
 * @author jiancheng
 * @date 2019-9-27
 * <p>
 * 说明
 * 修饰符的返回int值代表,0、标识默认/1、public/2、private/3、/4、protected
 * <p>
 * 问题：
 * 1、reflectionEnum是个枚举,为什么isEnumConstant返回false?
 * 2、什么叫复合字段
 */
@Data
public class ReflectionVO {

    private int testInt;
    private Integer testInteger;
    private String testString;
    String testStringDf;
    private BigDecimal testBigDecimal;
    private Date testDate;
    protected String testStringProtected;
    public String testStringPublic;
    private ReflectionEnum reflectionEnum;
    private ReflectionDetailVO reflectionDetailVO;
    private List<ReflectionDetailVO> reflectionDetailVOList;
}
