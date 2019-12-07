package com.example.springbootdemo.rest.requestmethod.resttemplate.controller;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import com.example.springbootdemo.rest.requestmethod.resttemplate.vo.RemoteResultVO;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RestController
@RequestMapping("restTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String urlPrefix = "localhost:8089/";

    @GetMapping("/getHello1")
    public ResultVO<RemoteResultVO> getHello1() {
        String urlPrefix = "http://pcsd-sme-bff-dev.earth.xpaas.lenovo.com/sme/v1/";
        String urlSuffix = "quotation/synchrostatus/{parameter}";
        String parameter = "dc27d123-87d4-4d9a-b34c-a06d4b11934d";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON_UTF8));
        headers.set("SERVICE-AUTHENTICATION", "eyJhbGciOiJIUzI1NiJ9.eyJzZXJ2aWNlTmFtZSI6IjgzOCIsInNlcnZpY2VLZXkiOiJhNWM4M2VjYzRlZWQ0YTc1OGI0MDc5OTcwMDZkY2ZmMiIsInNlcnZpY2VUeXBlIjoiMSIsInNlcnZpY2VBcHAiOiIzODAiLCJzZXJ2aWNlQ2x1c3RlciI6IjIiLCJqdGkiOiIxNTFhMDIwN2EwOTA0YzE5OTA0ZjJkZmIwYjRmZjBlMCIsImlhdCI6MTU2Njc5OTQ5MX0.2JzI1Ho6jCWTfvyernZCzpwFJlZpuMF9aBCINnWKFl0");

        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<RemoteResultVO> responseEntity = restTemplate.exchange(urlPrefix + urlSuffix, HttpMethod.GET, httpEntity, RemoteResultVO.class, parameter);
        RemoteResultVO body = responseEntity.getBody();
        return ResultVOBuilder.success(body);
    }


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
