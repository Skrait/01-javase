package com.monkey1024.cset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//HashMap遍历,,方式1
public class HashMap02 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1001, "成龙");
        map.put(1002, "周润发");
        map.put(1003, "周星驰");
        map.put(1001, "房祖名");

        //获取map中所有键的对象
        Set<Integer> set = map.keySet();
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            //获取set中的key数据
            Integer key = iter.next();
            String value = map.get(key);
            System.out.println("键：" + key + "值：" + value);


        }


    }
}
