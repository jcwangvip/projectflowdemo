package com.example.springbootdemo.rest.restfuldemo.readfiledemo;

import com.example.springbootdemo.common.utils.JsonLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2020-9-8
 */
@Slf4j
@RestController
public class ReadResourcesController {

    private final ConfigurationPropertiesConfig configurationPropertiesConfig;

    public ReadResourcesController(ConfigurationPropertiesConfig configurationPropertiesConfig) {
        this.configurationPropertiesConfig = configurationPropertiesConfig;
    }

    @GetMapping("/read/yml")
    public ConfigurationPropertiesConfig readYml() {
        log.info("configurationPropertiesConfig = {}", JsonLocalUtil.writeValueAsString(configurationPropertiesConfig));
        assert configurationPropertiesConfig.getName() != null;
        assert configurationPropertiesConfig.getOwner() != null;
        return configurationPropertiesConfig;
    }

}
