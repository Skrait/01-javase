package com.monkey1024.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 求增长率
 * 计算测试类
 */
public class GrowthRate {
    public String percentBigDecimal(BigDecimal preNum, BigDecimal sufNum){
        double result = countDecimal(preNum,sufNum);
        if(result>0){
            return "+"+result+"%";
        }
        if(result<0){
            return result+"%";
        }
        if(result==0){
            return "+"+0+"%";
        }
        return null;
    }


    public  double countDecimal(BigDecimal preNum,BigDecimal sufNum){
        boolean preBoolean = verifyNum(preNum);
        boolean sufBoolean = verifyNum(sufNum);
        //同时为true计算
        if(preBoolean && sufBoolean){
            boolean b = verifyEqual(preNum, sufNum);
            if (!b){
                return realCountDecimal(preNum,sufNum);
            }
            if (b){
                return 0;
            }
        }
        if(!preBoolean && !sufBoolean){
            return 0;
        }
        if(!preBoolean){
            return 100;
        }
        return  0;
    }
    //验证数字是否为零和null
    public boolean verifyNum(BigDecimal num){
        if(null !=num && num.compareTo(BigDecimal.ZERO)!=0 ){
            return true;
        }
        return false;
    }

    //验证两个数字是否相等
    public boolean verifyEqual(BigDecimal preNum,BigDecimal sufNum){
        int n = preNum.compareTo(sufNum);
        //比较 -1 小于   0 等于    1 大于
        if(n==0){
            return true;
        }
        return false;
    }
    //真正计算
    public double realCountDecimal(BigDecimal preNum,BigDecimal sufNum){
        //(前面的数字-后面的数字)/后面的数字*100
        BigDecimal bigDecimal = (sufNum.subtract(preNum)).divide(preNum).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_UP);
        if (bigDecimal.compareTo(BigDecimal.ZERO) !=0){
            return  bigDecimal.doubleValue();
        }
        return 0;
    }

    public static void main(String[] args) {
        GrowthRate p = new GrowthRate();
        BigDecimal pre = new BigDecimal("6");
        BigDecimal suf = new BigDecimal("0");
        String percent = (p.realCountDecimal(pre, suf)) + "%";
        System.out.println(percent);
    }

    /**
     * 增长率测试
     */
    @Test
    public void getRateFloatTest(){
        float v = growthRateFloatNoPercent(30.0f, 20.0f);
        System.out.println(v);
    }

    /**
     * 增长率
     * @param sameMonth
     * @param lastMonth
     * @return
     */
    public static float growthRateFloatNoPercent(float sameMonth, float lastMonth) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(3);
        float growthNum =  0;
        numberFormat.format(growthNum);
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
                growthNum=lastMonth - sameMonth;
                float result = 0L;
                return  result;

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
            return  0L;

        } else
        {
            //如果相等，增长率为 0
            return 0L;
        }

    }


    /**
     * 增长率 带%和+-号测试
     */
    @Test
    public void growthRatePlusOrMinusTest(){
        String v = growthRatePlusOrMinus(0.0f, 20.0f);
        System.out.println(v);
    }


    /**
     * 增长率 带%和+-号
     * @param sameMonth
     * @param lastMonth
     * @return
     */
    public static String growthRatePlusOrMinus(float sameMonth, float lastMonth) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);

        float growthNum = 0;
        String growthPercent="0";
        if (lastMonth > 0 && sameMonth > 0) {
            if (sameMonth > lastMonth) {
                growthNum=sameMonth - lastMonth;
                float v =  growthNum /  lastMonth * 100;
                int v1 = (int) v;
                String s3 = String.valueOf(v1);
                growthPercent=  s3;
                return  "+" + growthPercent + "%";
            } else if (sameMonth < lastMonth) {
                //如果下个数小于上个数，则增长率 为 负
                growthNum=lastMonth - sameMonth;
                growthPercent= "-" + numberFormat.format(growthNum /  sameMonth * 100)  + "%";
                return  growthPercent;

            } else {
                //如果相等，增长率为 0
                return "0";
            }
        } else if (lastMonth > 0 && sameMonth == 0) {
            //如果上个数大于0，下个数为0，增长率为 0
            return "0";
        } else if ( sameMonth > 0 && lastMonth == 0) {
            //如果下个数大于0，上个数为0，增长率为 0
            growthNum= sameMonth- lastMonth;
            growthPercent=  numberFormat.format((float)growthNum / (float) sameMonth * 100);
            return  growthPercent;
        } else
        {
            //如果相等，增长率为 0
            return "0";
        }

    }

}