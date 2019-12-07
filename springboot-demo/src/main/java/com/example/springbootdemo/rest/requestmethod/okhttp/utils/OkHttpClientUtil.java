package com.example.springbootdemo.rest.requestmethod.okhttp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * HttpClient方式远程调用接口工具类
 *
 * @author jiancheng
 * @date 2019-5-16
 */
@Component
@Slf4j
public class OkHttpClientUtil {

    @Value("${testUrl}")
    private String testUrl;
    @Autowired
    ObjectMapper objectMapper;

    public String getHelloTest() throws IOException {
        String apiUrl = String.format(testUrl);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).get()
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        String responseBodyString = response.body().string();
        log.info("返回response_body结果{}", responseBodyString);
        return responseBodyString;
    }

    /**
     * get方式调用带参数的连接->http://localhost:8080/getNameHello?urlValue=http://127.0.0.1:8089/nameHello&name=zhangsan
     *
     * @param url 连接ual
     * @param map 携带的参数
     * @return
     * @throws IOException
     */
    public String getRequest(String url, Map<String, String> map) throws IOException {
        if (StringUtils.isBlank(url)) {
            return "url不能为空";
        }
        String apiUrl = getUrl(url, map);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).get()
                .addHeader("cache-control", "no-cache")
                .addHeader("SERVICE-AUTHENTICATION","eyJhbGciOiJIUzI1NiJ9.eyJzZXJ2aWNlTmFtZSI6IjgzOCIsInNlcnZpY2VLZXkiOiJhNWM4M2VjYzRlZWQ0YTc1OGI0MDc5OTcwMDZkY2ZmMiIsInNlcnZpY2VUeXBlIjoiMSIsInNlcnZpY2VBcHAiOiIzODAiLCJzZXJ2aWNlQ2x1c3RlciI6IjIiLCJqdGkiOiIxNTFhMDIwN2EwOTA0YzE5OTA0ZjJkZmIwYjRmZjBlMCIsImlhdCI6MTU2Njc5OTQ5MX0.2JzI1Ho6jCWTfvyernZCzpwFJlZpuMF9aBCINnWKFl0")
                .build();
        Response response = client.newCall(request).execute();
        String responseBodyString = response.body().string();
        log.info("返回response_body结果{}", responseBodyString);
        return responseBodyString;
    }

    public String postRequest(String url, Map<String, String> map) throws IOException {
        if (StringUtils.isBlank(url)) {
            return "url不能为空";
        }
        String apiUrl = url;
        FormBody.Builder builder = new FormBody.Builder();
        map.forEach((a, b) -> builder.add(a, b));
        RequestBody requestBody = builder.build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).post(requestBody)
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        String responseBodyString = response.body().string();
        log.info("返回response_body结果{}", responseBodyString);
        return responseBodyString;
    }


    private String getUrl(String url, Map<String, String> map) {
        String apiUrl = String.format(url);
        StringBuilder sb = new StringBuilder();
        if (map.size() > 0) {
            map.forEach((a, b) -> sb.append(a + "=" + b + "&"));
            if (sb.length() > 0) {
                String parameters = sb.toString();
                if (parameters.endsWith("&")) {
                    parameters = parameters.substring(0, parameters.length() - 1);
                }
                url = url + "?" + parameters;
            }
            apiUrl = String.format(url);
        }
        return apiUrl;
    }


}
