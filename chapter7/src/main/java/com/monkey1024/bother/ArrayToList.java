package com.monkey1024.bother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        //数组转集合
        String[] arr = {"a", "b", "c"};

        //将数组转换成集合
        List<String> list = Arrays.asList(arr);

        ArrayList<String> list1 = new ArrayList<String>(list);
        System.out.println(list1);
    }

}