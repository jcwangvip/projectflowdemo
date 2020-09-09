package com.example.springbootdemo.rest.restfuldemo.readfiledemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2020-9-8
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "test.owner")
public class ConfigurationPropertiesOwnerConfig {

    private String name;
    private Integer age;
    private List<String> list;
    private Map<String, String> oneMap;

}
