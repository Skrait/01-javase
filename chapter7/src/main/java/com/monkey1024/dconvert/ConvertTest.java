package com.monkey1024.dconvert;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 类型转换练习
 * @Author Peekaboo
 * Since 2021.10.21
 */
public class ConvertTest {

    @Test
    public void test1() {
        int i = 1;
        long[] b = {1, 2, 3, 4, 5};
        String s = Convert.toStr(i);
        System.out.println(s);
    }

    @Test
    public void test2() {
        HashMap<String, Object> map = new HashMap<>();
    }

    //字符数组转化为整型数组
    @Test
    public void test3(){
        String[] c = { "1", "2", "3", "4", "5"};
        int[] a = new int[c.length];
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(c[i]);
            System.out.println(a[i]);
        }
        System.out.println(a[1]);
    }

    //Object类玩，每一个类都是Object的子类
    @Test
    public void test4(){
        Object s = "Kobe object";
        String s1 = s.toString();
        System.out.println(s);
        System.out.println(s1);

    }

    //String转Int
    @Test
    public void test5(){
        String s = "0001";
        int i1 = Integer.parseInt(s);
        System.out.println(i1);

    }

    //Int转String
    @Test
    public void test6(){
        int i1 = 0001;
        String s = Integer.toString(i1);
        String s1 = String.valueOf(i1);
        System.out.println(s);
        System.out.println(s1);


    }

}