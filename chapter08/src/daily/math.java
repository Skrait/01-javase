package daily;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Author Peekaboo
 * Date 2022/1/1 11:51
 */
public class math {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a1 = input.nextInt();
        int d = input.nextInt();
        int n = input.nextInt();
        int totalNum;
        totalNum = ((n*n) * d)/2+((a1-(d/2)))*n;
        System.out.println("前"+n+"项为：" + totalNum);

    }

//    @Test
//    public int dayNum(int year){
//        if(year==0){
//            return LocalDate.now().lengthOfYear();
//        }else{
//            return LocalDate.of(year,1,1).lengthOfYear();
//        }
//    }
    @Test
    public void dayNum(){
        LocalDate now = LocalDate.now();
        //获取当前年份有多少天
        int i = now.lengthOfYear();
        //获取当前是哪一年
        int nowYear = now.getYear();
        int cuMonthLength = now.getDayOfMonth();
        System.out.println("当前年份:" + nowYear +"的天数："+i +"当前月的天数：" +cuMonthLength);
    }

    //百分比
    @Test
    public void percent(){
        NumberFormat  numberFormat = NumberFormat.getPercentInstance();
        float i = 2;
        float j = 4;
        float p3 = i/j;
        String result;
        result = numberFormat.format(p3);
    }
}
