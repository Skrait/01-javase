package com.monkey1024.number;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Peekaboo
 * @date 2022年11月23日 9:24
 * 数值计算
 */
public class NumCalculate {

    @Test
    public void getPercentTest1(){
        String percent1 = getPercent(3, 12);
        String percent2 = getPercent(5, 12);
        String percent3 = getPercent(4, 12);
        System.out.println(percent1 + percent2  + percent3);

    }


    /**
     * 方式一：使用java.text.NumberFormat实现
     * @param x
     * @param y
     * @return
     */
    public static String getPercent(int x, int y) {
        double d1 = x * 1.0;
        double d2 = y * 1.0;
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        // 设置保留几位小数，这里设置的是保留两位小数
        percentInstance.setMinimumFractionDigits(2);
        return percentInstance.format(d1 / d2);
    }

    /**
     * 方式二：使用java.text.DecimalFormat实现
     * @param x
     * @param y
     * @return
     */
    public static String getPercent2(int x, int y) {
        double d1 = x * 1.0;
        double d2 = y * 1.0;
        // 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留四位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        return decimalFormat.format(d1 / d2);
    }
}
