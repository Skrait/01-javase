package com.monkey1024.Date;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Test
    public void timeTest2(){
        //获取当前时间戳
        long l = System.currentTimeMillis();
        Long l1 = 1644800000000L;
        System.out.println(l);

        //用Hutool工具格式化时间戳
        Date date = new Date(l1);
        String format = DateUtil.format(date,"yyyy-MM-dd HH:mm:ss");
        System.out.println(format + "  dateUtil");

        //用java8 DateTimeFormatter

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);


    }
}
