package com.monkey1024.cset;

import org.junit.Test;

import java.util.*;

public class HashMap4 {

    /*entry方式已遍历map，比价通用*/
    @Test
    public void entryMapTest(){
        HashMap<String, String> map = new HashMap<>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        map.put("熊三", "蓝色");


        for (Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("key：" + entry.getKey() + "  value：" + entry.getValue());
        }
    }

    /*单独遍历key或者value，性能比entry好*/
    @Test
    public void singleMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");

        for (String key : map.keySet()){
            System.out.println("key：" + key);
        }

        for (String value : map.values()){
            System.out.println("value：" + value);
        }
    }

    @Test
    public void mapTest(){
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }

    @Test
    public void linkedHashMapTest(){
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");

        for (String key : linkedHashMap.keySet()){
            System.out.println("key" + key);
        }

        for (String values : linkedHashMap.values()){
            System.out.println("key" + values);
        }


    }
}
