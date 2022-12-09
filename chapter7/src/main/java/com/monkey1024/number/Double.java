package com.monkey1024.number;

import org.junit.Test;

import java.math.BigDecimal;

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
    public void dividTest01(){
//        Float num1 = 0;
//        Float num2 = 100;
//        float result = 0 / 100;
        float v = Float.parseFloat("0");


        float v1 = Float.parseFloat("100");


    }
}
