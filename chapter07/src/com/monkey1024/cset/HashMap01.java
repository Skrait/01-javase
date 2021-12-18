package com.monkey1024.cset;

import java.util.Collection;
import java.util.HashMap;

public class HashMap01 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1001, "成龙");
        map.put(1002, "周润发");
        map.put(1003, "周星驰");
        map.put(1001, "房祖名");

        //判断是否包含传入的键
        System.out.println(map.containsKey(1002));
        //判断是否包含传入的值
        System.out.println(map.containsValue("周星驰"));
        //获取map的大小
        System.out.println(map.size());
        //将map中的值返回
        Collection<String> c = map.values();
        System.out.println(c);
        System.out.println(map);
        //删除键是1001的数据并且将值返回
        String s3 = map.remove(1001);

    }
}
