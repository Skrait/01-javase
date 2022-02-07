package com.monkey1024.Singleton;

import lombok.Synchronized;

/**
 * Author Peekaboo
 * Date 2022/1/22 23:29
 * 懒汉式单例
 */
public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan  = new LazyMan(); //不是一个原子性操作
                }
            }

        }

        return lazyMan;
    }
    //多线程并发
    public static void main(String[] args){
        for (int i = 0; i <10 ; i++) {
            new Thread(LazyMan::getInstance).start();
        }
    }
}
