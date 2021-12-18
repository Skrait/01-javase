package com.monkey1024.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections工具类简介
 *
 */
public class Collections01 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(6);
        list.add(9);
        //根据默认排序结果获取集合中的最大值
        System.out.println(Collections.max(list));
        //反转集合
        Collections.reverse(list);
        System.out.println("翻转集合" + list);
        //随机置换,可以用来洗牌
        Collections.shuffle(list);
        System.out.println("随机洗牌：" + list);
        //排序
        Collections.sort(list);
        System.out.println("sort排序：" + list);
        //二分法查找
        System.out.println(Collections.binarySearch(list, 6));
    }

}