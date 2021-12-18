package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListRemove02 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("a");
        list.add("b");
        list.add("monkey");
        list.add("c");
        list.add("d");

        Iterator iter = list.iterator();
        while (iter.hasNext()){
            String next = (String)iter.next();
            if ("monkey".equals(next)){
                list.add("1024");
            }
        }


    }
}
