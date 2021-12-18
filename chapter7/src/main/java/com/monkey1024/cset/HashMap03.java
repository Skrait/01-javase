package com.monkey1024.cset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap03 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1001, "成龙");
        map.put(1002, "周润发");
        map.put(1003, "周星驰");
        map.put(1004, "刘德华");

        //map的键和值放到了Entry对象，该对象放入
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            //获取Entry对象
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();

            System.out.println("键：" + key + "，值：" + value);
        }

    }
}
