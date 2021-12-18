package com.monkey1024;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest01 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        System.out.println(c);

        c.remove("c");
        System.out.println(c);
        //将集合转换为数组并输出
        Object [] o = c.toArray();
        for (int i = 0; i < o.length; i++){
            System.out.println();
        }

    }
}
