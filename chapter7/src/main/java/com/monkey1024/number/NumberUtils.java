package com.monkey1024.number;

import com.monkey1024.vo.PercentVo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberUtils {
 
    /**
     * 最大余额法，精度为整数
     *
     * @param list
     */
    public static void calculatePercent(List<PercentVo> list) {
        //求和：总票数
        int sum = list.stream().mapToInt(PercentVo::getNumber).sum();
        for (PercentVo percentVo : list) {
            double value = percentVo.getNumber() * 100 / (double) sum;
            int valueInt = (int) value;
            //设置对应的百分比
            percentVo.setPercent(valueInt);
            //获取小数点后的值
            percentVo.setPoint(value - valueInt);
            System.out.println("percentVo = " + percentVo);
        }
        //求和：当前各项百分比合计。由于我们舍弃了小数位，所以该合计只会小于等于100
        int curSum = list.stream().mapToInt(PercentVo::getPercent).sum();
        while (curSum < 100) {
            //找出小数余额最大的组，对其进行加1
            PercentVo max = list.stream().max(Comparator.comparingDouble(PercentVo::getPoint)).get();
            max.setPercent(max.getPercent() + 1);
            //当前这个数已经加1了，不应该参与下一轮的竞选
            max.setPoint(0.0);
            curSum++;
        }
    }
 
    public static void main(String[] args) {
        PercentVo v1 = new PercentVo(10, "A组");
        PercentVo v2 = new PercentVo(12, "B组");
        PercentVo v3 = new PercentVo(7, "C组");
        List<PercentVo> list = Arrays.asList(v1, v2, v3);
        System.out.println("处理前--------------------------");
        calculatePercent(list);
        System.out.println("处理后--------------------------");
        for (PercentVo percentVo : list) {
            System.out.println(percentVo);
        }
    }
}