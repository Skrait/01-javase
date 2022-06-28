package com.jg.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class DistinctSimpleDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long count = list.stream().distinct().count();
        System.out.println("No. of distinct elements:3" + count);
        String collect = list.stream().distinct().collect(Collectors.joining("2"));

        System.out.println(collect);
    }
} 