package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;


public class Iterator01 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("a");
        list.add("b");
        list.add("monkey");
        list.add("c");
        list.add("d");


        for (int i = 0; i < list.size(); ) {
            list.remove(i);
        }
        System.out.println(list);
    }
}
