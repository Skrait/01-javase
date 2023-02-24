package com.monkey1024.Date;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * Author Peekaboo
 * Date 2021/12/27 19:49
 */
@Slf4j
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

    /**
     * 获取今年最后一天
     */
    @Test
    public void getLastDay(){
        LocalDateTime now = LocalDateTime.now();
        //获取当月第一天
        System.out.println("当月第一天："+now.with(TemporalAdjusters.firstDayOfMonth()));
        //获取下月第一天
        System.out.println("下月第一天："+now.with(TemporalAdjusters.firstDayOfNextMonth()));
        //获取明年第一天
        System.out.println("明年第一天："+now.with(TemporalAdjusters.firstDayOfNextYear()));
        //获取本年第一天
        System.out.println("本年第一天："+now.with(TemporalAdjusters.firstDayOfYear()));
        //获取当月最后一天
        System.out.println("当月最后一天："+now.with(TemporalAdjusters.lastDayOfMonth()));
        //获取本年最后一天
        System.out.println("本年最后一天："+now.with(TemporalAdjusters.lastDayOfYear()));
        //获取当月第三周星期五
        System.out.println("当月第三周星期五："+now.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));
        //获取上周一
        System.out.println("上周一："+now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        //获取下周日
        System.out.println("下周日："+now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

    }

    /**
     * Date类型参数
     * 时间加减分钟计算
     * 开始时间+时间段=结束时间
     * @param startDate 开始时间
     * @param timeSolt 时间段，分钟
     * @return 开始时间+时间段
     * @throws ParseException
     */
    public static Date getBeforeDate(Date startDate, Integer timeSolt) {
        if(startDate == null){
            return null;
        }
        Date beforeDate = null;
        //方法一
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MINUTE, timeSolt);
        beforeDate = calendar.getTime();
        System.out.println("1111----"+beforeDate);
        //方法二
        Long time = timeSolt*60*1000L;
        Date beforeDate2 = new Date(startDate.getTime() + time);
        System.out.println("2222----"+beforeDate2);
        return beforeDate;
    }


    /**
     * 开始时间+时间段=结束时间
     * @param startDate 开始时间
     * @param timeSolt 时间段，分钟
     * @return 开始时间+时间段
     * @throws ParseException
     */
    public static Date getBeforeDate(String startDate, Integer timeSolt) {
        if(StringUtils.isEmpty(startDate) || null == timeSolt){
            return null;
        }
        Date beforeDate = null;
        try {
            //方法一
            Date date = defaultFormat(startDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, timeSolt);
            beforeDate = calendar.getTime();
            System.out.println("1111----"+beforeDate);
            //方法二
            Long time = timeSolt*60*1000L;
            Date beforeDate2 = new Date(date.getTime() + time);
            System.out.println("2222----"+beforeDate2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return beforeDate;
    }

    //字符串转date
    public static Date defaultFormat(String dateStr) throws ParseException {
        if ((StringUtils.isBlank(dateStr))) {
            return null;
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simple.parse(dateStr);
    }


    public static void main(String[] args) {
        getBeforeDate("2022-06-21 17:31:58",-1);
    }


    /**
     * 字符串转换为制定格式日期
     * (注意：当你输入的日期是2014-12-21 12:12，format对应的应为yyyy-MM-dd HH:mm
     * 否则异常抛出)
     * @param date
     * @param format
     * @return
     * @throws ParseException
     *    @
     */
    public static Date formatStringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.toString());
        }
    }


    //常用变量
    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_HMS = "HH:mm:ss";
    public static final String DATE_FORMAT_HM = "HH:mm";
    public static final String DATE_YEAR = "yyyy";
    public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YMDHMS = "yyyyMMddHHmmss";
    public static final long ONE_DAY_MILLS = 3600000 * 24;
    public static final long ONE_HOUR_MILLS = 3600000;//小时单位
    public static final long ONE_MINUTE_MILLS = 60000; //分钟单位
    public static final int WEEK_DAYS = 7;
    private static final int dateLength = DATE_FORMAT_YMDHM.length();


    /**
     * 日期转换为制定格式字符串
     *
     * @param time
     * @param format
     * @return
     */
    public static String formatDateToString(Date time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }

    @Test
    public void getListOfHoursBetweenTest(){
        List<String> listOfHoursBetween = getListOfHoursBetween("2022-10-15 14:00:00", 10);


    }

    /**
     * 获取最近1小时的所有分钟整点 List
     */
    @Test
    public void getMinuteListBeforeHourTest(){
        List<String> minuteListBefore = getMinuteListBefore("2022-10-15 14:00:00", 59,"yyyy-MM-dd HH:mm:00");


    }

    public static List<String> getListOfHoursBetween(String startTime, int i) {
        Date date = formatStringToDate(startTime, DATE_FORMAT_FULL);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        List<String> strings=new ArrayList<>();
        strings.add(startTime);
        for (int i1 = 0; i1 < i; i1++) {
            date = new Date(instance.getTimeInMillis() -  ONE_HOUR_MILLS);
            instance.setTime(date);
            String s = formatDateToString(date, DATE_FORMAT_FULL);
            strings.add(s);
        }
        return strings;
    }


    /**
     * 获取最近n个分钟整点 List
     */
    public static List<String> getMinuteListBefore(String startTime, int i,String stringFormate) {
        Date date = formatStringToDate(startTime, stringFormate);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        List<String> strings=new ArrayList<>();
        strings.add(startTime);
        for (int i1 = 0; i1 < i; i1++) {
            date = new Date(instance.getTimeInMillis() -  ONE_MINUTE_MILLS);
            instance.setTime(date);
            String s = formatDateToString(date, stringFormate);
            strings.add(s);
        }
        return strings;
    }

    //获取当月最近一天(返回String)
    @Test
    public void getLastDayOfYearString(){
        //获取当月最近一天
        Date nowTime = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar first = Calendar.getInstance(Locale.CHINA);
        Calendar last = Calendar.getInstance(Locale.CHINA);
        first.setTime(nowTime);
        last.set(Calendar.DAY_OF_MONTH,first.getActualMinimum(Calendar.DAY_OF_MONTH)); //当月第一天
        last.set(Calendar.HOUR_OF_DAY,first.getActualMinimum(Calendar.HOUR_OF_DAY)); //00小时
        last.set(Calendar.MINUTE,last.getActualMinimum(Calendar.MINUTE)); //最早分钟
        last.set(Calendar.SECOND,last.getActualMinimum(Calendar.SECOND)); //最早秒
        System.out.println(last.getTime());
    }

    /**
     * 获取前30天的时间
     */
    @Test
    public void getLast30Day(){
        Date nowDate = new Date();
        Calendar nowCalendar = Calendar.getInstance(Locale.CHINA);
        nowCalendar.setTime(nowDate);
        nowCalendar.set(Calendar.DAY_OF_MONTH,-100);
        Date time = nowCalendar.getTime();
        System.out.println(time);
    }


    /**
     * 获取当年12个月
     * @param
     * @param
     * @return
     */
    @Test
    public void get12Month() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(Calendar.MONTH,12); //00小时

        List<String> strings=new ArrayList<>();

        for (int i1 = 0; i1 < 12; i1++) {
            calendar1.add(Calendar.MONTH,-1);
            Date time1 = calendar1.getTime();
            strings.add(sdf2.format(time1));
        }
        System.out.println(strings);
    }

    /**
     * 获取当前时间所在年份的最早时间(精确到秒)
     */
    @Test
    public void getFistTimeOfYear(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,calendar.getActualMinimum(Calendar.SECOND));
        System.out.println(calendar.getTime());
    }

    /**
     * 获取当前时间所在年份的最早时间(精确到秒)
     */
    @Test
    public void getLastTimeOfYear(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,calendar.getActualMaximum(Calendar.SECOND));
        System.out.println(calendar.getTime());
    }

    /*
     * 获取最近n月份的List
     * 包含当前月份
     */
    @Test
    public void getNMonth(){
        ArrayList<Date> data = new ArrayList<>();
        ArrayList<String> dataString = new ArrayList<>();
        //格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        ArrayList<LocalDateTime> localDateS = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int i = 0; i < 6; i++) {
            calendar.add(Calendar.MONTH, - 1);
            Date time = calendar.getTime();
            dataString.add(dateTimeFormatter.format(date2LocalDate(time)));
            data.add(time);
        }
        System.out.println(dataString);
        //System.out.println(data);


    }

    public LocalDateTime date2LocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
//        System.out.println("Date = " + date);
//        System.out.println("LocalDate = " + localDate);
        return localDateTime;
    }

    /*
    获取本年度的十二个月份 yyyy-MM
     */
    @Test
    public void getMonthByYear(){
        List<String> monthByYear = com.monkey1024.Date.DateUtil.getMonthByYear();
        System.out.println(monthByYear);
    }

    /**
     * 获取去年年份
     * @return 年份
     */
    @Test
    public void getLastYear() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date newDate = dateFormat.parse("2022");
        Calendar ca = Calendar.getInstance();
        ca.setTime(newDate);
        ca.add(Calendar.YEAR,-1);
        Date year = ca.getTime();
        String yearDate = dateFormat.format(year);
        System.out.println(yearDate);
    }

}
