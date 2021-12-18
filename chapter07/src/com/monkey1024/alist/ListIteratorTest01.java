package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//通过注解去除黄色警告
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ListIteratorTest01 {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("world");
        list.add("c");
        list.add("d");
        list.add("e");

        //在ListIterator中有个previous()和hasPrevious()方法

        ListIterator listIter = list.listIterator();
        while(listIter.hasNext()) {
            System.out.println(listIter.next());//获取元素并将指针向后移动
        }

        System.out.println("-----------------");

        while(listIter.hasPrevious()) {
            System.out.println(listIter.previous());         //获取元素并将指针向前移动
        }
    }

}
