package com.monkey1024.dpattern;

/**
 * Author Peekaboo
 * Date 2022/2/6 19:06
 * 装饰者设计模式
 * 优点：不必修改被装饰者(Noodle)的源码前提下就能添加功能(加辣椒)，
 * 并且对于Noodle类来说它是不知道加辣椒的存在的
 * 耦合度不高
 * 但站在ChiliNoodle(装饰者)角度来说是有一定耦合的
 */
public class Test {
    public static void main(String[] args) {
        //做一碗普通拉面
        Noodle noodle = new Noodle();
        noodle.addThings();
        //将普通拉面编程加辣椒的拉面
        ChiliNoodle cn = new ChiliNoodle(new Noodle());
        cn.addThings();

    }
}
