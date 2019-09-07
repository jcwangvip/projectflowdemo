package com.example.springbootdemo.rest.requestmethod.okhttp.controller;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import com.example.springbootdemo.rest.requestmethod.okhttp.utils.OkHttpClientUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * okhttp方式测试
 *
 * @author jiancheng
 * @date 2019-5-16
 */
@RestController
@RequestMapping("okhttp")
public class OkHttpController {

    @Autowired
    OkHttpClientUtil okHttpClientUtil;

    @GetMapping("/get")
    public ResultVO<String> getHello() throws IOException {
        String result = okHttpClientUtil.getHelloTest();
        return ResultVOBuilder.success(result);
    }


    @GetMapping("/getName")
    public ResultVO<String> getNameHello(@RequestParam Map<String, String> map) throws IOException {
        String url = map.get("urlValue");
        map.remove("urlValue");
        String result = okHttpClientUtil.getRequest(url, map);
        return ResultVOBuilder.success(result);
    }


    @ApiOperation(value = "测试Post请求http://localhost:8080/testPost?name=zhangsan&urlValue=http://127.0.0.1:8089/nameHello")
    @GetMapping("/testPost")
    public ResultVO<String> testPost(@RequestParam Map<String, String> map) throws IOException {
        String url = map.get("urlValue");
        map.remove("urlValue");
        String result = okHttpClientUtil.postRequest(url, map);
        return ResultVOBuilder.success(result);
    }


}
