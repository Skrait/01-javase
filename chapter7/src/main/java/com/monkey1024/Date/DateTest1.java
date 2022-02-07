package com.monkey1024.Date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * Author Peekaboo
 * Date 2021/12/27 19:49
 */
public class DateTest1 {

    @Test
    public void DateTest1(){
        //获取当前时间24小时前的时间
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY,c.get(Calendar.HOUR_OF_DAY) - 24);
        Date time = c.getTime();

        System.out.println(time);

    }

    @Test
    public void MapTest1(){
        HashMap<String, Object> map = new HashMap<>();
        Object obj = 1;
        map.put("col8",85);
        map.put("col9",90);
        map.put("col10",99);

        map.put("pm10",map.remove("col8"));

        //获取KeySet
        Set<String> strings = map.keySet();
        String objKey = null;
        for (String s: strings){
            //获取键值KeySet
            objKey = s;
        }
        System.out.println(objKey);
    }
}
