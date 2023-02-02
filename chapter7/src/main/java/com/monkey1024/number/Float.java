package com.monkey1024.number;

import org.junit.Test;

import java.text.NumberFormat;

/**
 * @author Peekaboo
 * @date 2023年01月16日 16:30
 * float运算测试
 */
public class Float {

    @Test
    public void floatTest1 (){
        float f1 = growthRateFloatNoPercent(100, 200);
        System.out.println(f1);

    }

    public static float growthRateFloatNoPercent(float sameMonth, float lastMonth) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);
        float growthNum=0;
        //String growthPercent="0";
        if (lastMonth > 0 && sameMonth > 0) {
            if (sameMonth > lastMonth) {
                growthNum=sameMonth - lastMonth;
                float v =  growthNum /  lastMonth * 100;
                int v1 = (int) v;
                //保留0位小数
                v = ( float )(Math.round(v * 1));
                //String s3 = String.valueOf(v1);
                return  v;
            } else if (sameMonth < lastMonth) {
                growthNum= sameMonth- lastMonth;
                return  (float)(Math.round( (growthNum  / sameMonth) *10))/10 * 100;

            } else {
                //如果相等，增长率为 0
                return 0L;
            }
        } else if (lastMonth > 0 && sameMonth == 0) {
            //如果上个数大于0，下个数为0，增长率为 0
            return 0L;
        } else if (lastMonth == 0 && sameMonth > 0) {
            //如果下个数大于0，上个数为0，增长率为 0
            growthNum= sameMonth- lastMonth;
            return  (float)(Math.round( (growthNum  / sameMonth) *10))/10;

        } else
        {
            //如果相等，增长率为 0
            return 0L;
        }

    }
}
