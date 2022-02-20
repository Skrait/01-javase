package com.monkey1024.EqualAndHashCode;

import java.util.Objects;

/**
 * Author Peekaboo
 * Date 2022/2/17 16:08
 */
public class EqualAndHashCodeTest {
    public static void main(String[] args) {
        Child childTest1 = new Child();
        childTest1.setCode("1");
        childTest1.setName("child");

        Child childTest2 = new Child();
        childTest2.setCode("2");
        childTest2.setName("child");

        boolean equals = Objects.equals(childTest1, childTest2);
        System.out.println(equals);

    }
}
