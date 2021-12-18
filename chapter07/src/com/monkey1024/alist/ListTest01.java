package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.List;

/**
 * List特有的方法
 *
 */
//通过注解去除黄色警告
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ListTest01 {

    public static void main(String[] args) {
        /*addTest();
        removeTest();*/
        getTest();
        setTest();
    }

    public static void setTest() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //将指定位置的元素修改
        list.set(1, "z");
        System.out.println(list);
    }

    public static void getTest() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Object obj1 = list.get(2);
        System.out.println(obj1);
        //通过索引遍历List集合
        for(int i = 0;i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}