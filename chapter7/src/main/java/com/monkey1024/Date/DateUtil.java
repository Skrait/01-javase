package com.monkey1024.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Peekaboo
 * @date 2023年02月08日 11:10
 */
public class DateUtil {

    /*
    获取本年度的十二个月份 yyyy-MM
     */
    public static List<String> getMonthByYear(){
        List<String> data = new ArrayList<>();
        try {
            Calendar nowCalendar = Calendar.getInstance();
            // 获取当前的年份
            int year = nowCalendar.get(Calendar.YEAR);
            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            // 开始日期为当前年拼接1月份
            Date startDate = sdf.parse(year + "-01");
            // 结束日期为当前年拼接12月份
            Date endDate = sdf.parse(year + "-12");
            // 设置calendar的开始日期
            nowCalendar.setTime(startDate);
            // 当前时间小于等于设定的结束时间
            while(nowCalendar.getTime().compareTo(endDate) <= 0){
                String time = sdf.format(nowCalendar.getTime());
                data.add(time);
                // 当前月份加1
                nowCalendar.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}
