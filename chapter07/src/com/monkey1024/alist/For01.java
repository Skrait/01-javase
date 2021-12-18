package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.List;

/**
 * 增强for循环
 *
 */
public class For01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("d");

        //增强for循环，优点是可以简化遍历
        for(String s1 : list){
            System.out.print(" " + s1);
        }

    }

}