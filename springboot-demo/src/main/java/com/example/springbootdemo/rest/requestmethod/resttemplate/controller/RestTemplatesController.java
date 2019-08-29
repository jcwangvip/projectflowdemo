package com.example.springbootdemo.rest.requestmethod.resttemplate.controller;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

/**
 * RestTemplateController
 *
 * @author jiancheng
 * @date 2019-7-16
 */
@RestController("restTemplatesss")
public class RestTemplatesController {

    @Autowired
    RestTemplate restTemplate;

    private static final String urlPrefix = "localhost:8089/";

    @GetMapping("/getHello")
    public ResultVO<String> getHello() {
        String urlSuffix = "getHello";
        String result = restTemplate.getForObject(urlPrefix + urlSuffix, String.class);
        return ResultVOBuilder.success(result);
    }


    @GetMapping("/getNameHello")
    public ResultVO<String> getNameHello(@RequestParam Map<String, String> map) throws IOException {
        String url = map.get("urlValue");
        map.remove("urlValue");
        String urlSuffix = "getNameHello";
        String result = restTemplate.postForObject(urlPrefix + urlSuffix, null, String.class);
        return ResultVOBuilder.success(result);
    }


    @ApiOperation(value = "测试Post请求http://localhost:8080/testPost?name=zhangsan&urlValue=http://127.0.0.1:8089/nameHello")
    @GetMapping("/testPost")
    public ResultVO<String> testPost(@RequestParam Map<String, String> map) throws IOException {
        String url = map.get("urlValue");
        map.remove("urlValue");
        String urlSuffix = "getHello";
        String result = restTemplate.postForObject(urlPrefix + urlSuffix, null, String.class);
        return ResultVOBuilder.success(result);
    }

}
