package com.monkey1024.cset;

import java.util.HashSet;

/**
 * Set的特点：元素不能重复，没有索引，存取顺序不一致
 *
 */
public class HashSetTest01 {

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();
        boolean b1 = hs.add("a");
        // 当向set集合中存储重复元素的时候返回为false
        boolean b2 = hs.add("a");
        hs.add("b");
        hs.add("c");
        hs.add("d");
        System.out.println(hs);
        System.out.println(b1);
        System.out.println(b2);
        //可以使用增强for循环或者迭代器进行遍历
        //只要能用迭代器遍历就能使用增强for循环遍历
        for (String string : hs) {
            System.out.println(string);
        }
    }

}