package com.example.springbootdemo.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * json工具
 *
 * @author jiancheng
 * @date 2020-8-25
 */
public class JsonLocalUtil {

    public static String writeValueAsString(Object data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T readJsonFile(String filename, Class<T> clazz) {
        return parseObject(new JsonLocalUtil().readFile(filename).collect(Collectors.joining()), clazz);
    }

    private Stream<String> readFile(String filename) {
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource(filename)).getPath();
        try {
            return Files.lines(new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    public static <T> T parseObject(String bodyValue, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
//        return JSONObject.parseObject(bodyValue, valueType);
        try {
            return objectMapper.readValue(bodyValue, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseObject(Map<String, Object> bodyValue, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(bodyValue), valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> parseObject(List<Map<String, Object>> list, Class<T> valueType) {
        try {
            if (CollectionUtils.isEmpty(list)) {
                return Collections.singletonList(valueType.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.stream().map(x -> parseObject(x, valueType)).collect(Collectors.toList());
    }


}
