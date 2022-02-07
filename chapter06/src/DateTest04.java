import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest04 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) +  "年");
        System.out.println(c.get(Calendar.MONTH) +  "月");
        System.out.println(c.get(Calendar.DAY_OF_MONTH) +  "日");
        System.out.println("星期" + c.get(Calendar.DAY_OF_WEEK));

    }

    @Test
    public void dateTest1(){
        //获取当前年份第一天
        Calendar orCalendar = Calendar.getInstance();
        int nowYear = orCalendar.get(Calendar.YEAR);
        orCalendar.clear();
        orCalendar.set(Calendar.YEAR, nowYear);
        Date oriDate = orCalendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String oriTime = format.format(oriDate);

        //获取当前时间，精确到天
        Calendar cuCalendar =  Calendar.getInstance();
        Date nowDate = cuCalendar.getTime();
        String nowTime = format.format(nowDate);

        //当前年份和今天的天数差
        int days = (int)((nowDate.getTime() - oriDate.getTime()) / (1000*3600*24));

    }

    @Test
    public void  getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        System.out.println(sdf.format(date));

    }
}
