package com.example.springbootdemo.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试获取资源
 *
 * @author jiancheng
 * @date 2019-6-17
 */
@Slf4j
public class FileUtilsTest {

    @Test
    public void getResourcesFile() {
        String resourcesFile = FileUtils.getResourcesFile("classpath:json/request.json");
        log.info("resourcesFile = {}", resourcesFile);
    }
}