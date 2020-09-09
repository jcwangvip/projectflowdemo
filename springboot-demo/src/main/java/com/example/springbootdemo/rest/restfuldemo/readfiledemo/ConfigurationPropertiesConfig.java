package com.example.springbootdemo.rest.restfuldemo.readfiledemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 读取yml配置文件的配置类
 * <p>
 * 嵌套读取yml用直接类不管用localClassInfo
 *
 * @author jiancheng
 * @date 2020-9-8
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "test")
public class ConfigurationPropertiesConfig {

    private String name;
    private String type;
    private List<String> oneList;
    private List<String> oneList1;
    private Map<String, String> oneMap;
    private ConfigurationPropertiesOwnerConfig owner;
    private LocalClassInfo localClassInfo;

}
