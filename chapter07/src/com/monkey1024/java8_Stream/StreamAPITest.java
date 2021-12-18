package com.monkey1024.java8_Stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class StreamAPITest {
    
    //常见Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = {1, 2, 3, 4, 5, 6};

        Arrays.stream(arr);

    }

    //排序
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(12, 42, 65, 34, 87, 0, 98, 7);
        list.stream().sorted().forEach(System.out::print);
        list.stream().sorted().forEach(e-> System.out.println(e));

    }
    //map映射测试
    @Test
    public void mapTest(){
        List<String> ls = new ArrayList<>();
        ls.add("小白");
        ls.add("小黑子");
        ls.add("蓝天白");
        ls.add("小红");
        String b = "小红";

        //map映射，变为新的字符串
        ls.stream().map(a -> b).forEach(System.out::println);

        //map转为一个学生对象
        //ls.stream().map( b -> new Student(b,22)).forEach(System.out::println);
        //ls.forEach(System.out::println);
    }

    @Test
    public void mapTest2(){
        Map<String, String> map = new HashMap<>();
        map.put("1","23");
        map.put("1","24");

        System.out.println(map.get("1"));

    }
}
