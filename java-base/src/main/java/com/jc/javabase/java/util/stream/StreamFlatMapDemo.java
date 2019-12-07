package com.jc.javabase.java.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 测试flatMap方法
 *
 * @author jiancheng
 * @date 2019-11-20
 */
public class StreamFlatMapDemo {
    public static void main(String[] args) {

        String[] words = new String[]{"Hello", "World"};

        Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .findAny().ifPresent(System.out::println);
        System.out.println("------------");

        List<String[]> collect = Arrays.stream(words)
                .map(word -> word.split(""))
                .collect(Collectors.toList());
        // collect.forEach(System.out::println);
        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i)[i]);
        }

        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
        System.out.println();

    }
}
