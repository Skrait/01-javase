package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//使用ListIterator
public class ListRemove03 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("a");
        list.add("b");
        list.add("monkey");
        list.add("c");
        list.add("d");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            String next = (String)listIterator.next();
            if ("monkey".equals(next)){
                listIterator.add("1024");
            }
        }


    }
}
