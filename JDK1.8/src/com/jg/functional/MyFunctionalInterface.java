package com.jg.functional;

/**
 * 函数式接口：有且仅有一个抽象方法的接口
 *
 * @Author: 杨德石
 * @Date: 2020/2/24 16:24
 * @Version 1.0
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    /**
     * 仅有的抽象方法
     */
    void method();

    /**
     * 默认方法
     */
    default void defaultMethod() {
        System.out.println("接口默认方法");
    }

}
