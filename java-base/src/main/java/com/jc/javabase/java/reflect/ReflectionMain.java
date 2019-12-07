package com.jc.javabase.java.reflect;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-9-29
 */
@Slf4j
public class ReflectionMain {


    public static void main(String[] args) {
        ReflectionApiService service = new ReflectionApiService();
        ReflectionVO reflectionVO = new ReflectionVO();
        service.reflection(reflectionVO);
    }


}
