package com.monkey1024.Singleton;

/**
 * Author Peekaboo
 * Date 2022/1/22 23:21
 * 饿汉式
 */
public class Hungry {

    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    //单例模式最重要的一个思想是构造器私有话
    private Hungry(){

    }

    //一上来就把对象加载了,可能浪费内存空间
    private final static Hungry HUNGRY = new Hungry();

    //对外抛出一个方法
    public static Hungry getInstance1(){
        System.out.println("奥利给！！");

        return HUNGRY;
    }
}

class Test{
    public static void main(String[] args) {
        Hungry instance = Hungry.getInstance1();
        System.out.println(instance);

    }
}

