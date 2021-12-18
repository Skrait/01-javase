package com.monkey1024.bother;

import java.util.ArrayList;

public class ListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //将list转成数组
        String[] array = list.toArray(new String[6]);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
