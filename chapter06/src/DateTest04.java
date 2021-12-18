import java.util.Calendar;

public class DateTest04 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) +  "年");
        System.out.println(c.get(Calendar.MONTH) +  "月");
        System.out.println(c.get(Calendar.DAY_OF_MONTH) +  "日");
        System.out.println("星期" + c.get(Calendar.DAY_OF_WEEK));

    }
}
