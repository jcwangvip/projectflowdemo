package com.example.springbootdemo;

import com.example.springbootdemo.common.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 项目启动类
 *
 * @author jiancheng
 */
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Bean
    public ResultVOBuilder resultVOBuilder(@Autowired ResourceBundleMessageSource messageSource) {
        return new ResultVOBuilder(messageSource);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("errorMessage", "constantMessage", "globalErrorMessage");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

}
