package com.monkey1024.overload_26;

/**
 * Date 2022/6/15 15:57
 * MethodTest类重载版
 * @author Peekaboo
 * 方法重载
 */
public class MethodTestOverload{

    public static void main(String[] args){

        System.out.println(sum(10,20));

        System.out.println(sum(1.0,2.0));

        System.out.println(sum(10L,20L));

        System.out.println(sum(1.0F,2.0F));

    }

    public static int sum(int a,int b){
        return a + b;
    }

    public static double sum(double a,double b){
        return a + b;
    }

    public static long sum(long a,long b){

        return a + b;

    }

    public static float sum(float a,float b){
        return a + b;
    }

}