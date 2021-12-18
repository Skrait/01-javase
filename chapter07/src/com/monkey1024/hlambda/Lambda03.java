package com.monkey1024.hlambda;

import java.util.ArrayList;
import java.util.function.Consumer;

//使用lambda表达式+forEach方法遍历集合(集合)
public class Lambda03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        

        list.forEach((Integer i) -> {
            //替代匿名内部类。
            System.out.println(i);
        });

    }
}
