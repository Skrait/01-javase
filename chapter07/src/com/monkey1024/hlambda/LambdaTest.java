package com.monkey1024.hlambda;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("我爱天安门");
            }
        };

        r1.run();

        System.out.println("***********");
    }

    /**
     * 用lambda写法，箭头是lambda操作符
     */
    @Test
    public void test2(){
        Runnable r2 = () -> System.out.println("我爱北京lambda版");
        r2.run();
    }

    /**
     * 用lambda写法，箭头是lambda操作符
     */
    @Test
    public void test3(){
        Runnable r2 = () -> System.out.println("我爱北京lambda版");
        r2.run();
    }

    /**
     * 原始写法
     */
    @Test
    public void test4(){
        Comparator<Integer> com2 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
    }

    /**
     * lambda写法
     */@Test
    public void test5(){
        Comparator<Integer> com2 = (o1,o2) ->Integer.compare(o1,o2);

        int compare2 = com2.compare(32,21);
        System.out.println(compare2);
    }
}
