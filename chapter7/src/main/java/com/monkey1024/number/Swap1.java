package com.monkey1024.number;

/**
 * Author Peekaboo
 * Date 2022/2/28 13:04
 * 换数测试
 */
public class Swap1 {

    static int num1 = 10;
    static int num2 = 20;

    public static void main(String[] args) {


        swap(num1,num2);

        System.out.println("num1 = "+ num1);
        System.out.println("num2 = "+  num2);
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
