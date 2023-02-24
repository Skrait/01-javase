package com.monkey1024.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Author Peekaboo
 * Date 2022/1/14 15:01
 */
public class Double {

    @Test
    public void test01(){
        double d = 114.145;
        BigDecimal b = new BigDecimal(d);
        d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
    }

    @Test
    public void test02(){
        float num1 = 1;
        float num2 = 2;
        float result = num1 - num2;
        System.out.println(result);
    }

    @Test
    public void getPercentTest1(){
        int [] arr = {1,2};

        double[] percentValue = getPercentValue(arr);
        for (double v : percentValue) {
            System.out.println(v);
        }
        System.out.println(Arrays.toString(percentValue));

    }

    /*
    计算百分比,和为100%
     */
    public static double[] getPercentValue(int[] arr){
        //求和
        double sum = 0;
        if(sum <= 0){
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
        }
        //10的2次幂是100，用于计算精度。
        double digits = 1;
        //扩大比例100
        double[] votesPerQuota = new double[arr.length];
        for(int i = 0; i < arr.length; i++){
            double val = arr[i] / sum * digits * 100;
            votesPerQuota[i] = val;
        }
        //总数,扩大比例意味的总数要扩大
        double targetSeats = digits * 100;
        //再向下取值，组成数组
        double[] seats = new double[arr.length];
        for(int i = 0; i < votesPerQuota.length; i++){
            seats[i] = Math.floor(votesPerQuota[i]);
        }
        //再新计算合计，用于判断与总数量是否相同,相同则占比会100%
        double currentSum = 0;
        for (int i = 0; i < seats.length; i++) {
            currentSum += seats[i];
        }
        //余数部分的数组:原先数组减去向下取值的数组,得到余数部分的数组
        double[] remainder = new double[arr.length];
        for(int i = 0; i < seats.length; i++){
            remainder[i] = votesPerQuota[i] - seats[i];
        }
        while(currentSum < targetSeats){
            double max = 0;
            int maxId = 0;
            for(int i = 0;i < remainder.length;++i){
                if(remainder[i] > max){
                    max = remainder[i];
                    maxId = i;
                }
            }
            //对最大项余额加1
            ++seats[maxId];
            //已经增加最大余数加1,则下次判断就可以不需要再判断这个余额数。
            remainder[maxId] = 0;
            //总的也要加1,为了判断是否总数是否相同,跳出循环。
            ++currentSum;
        }
        // 这时候的seats就会总数占比会100%
        return seats;
    }

}
