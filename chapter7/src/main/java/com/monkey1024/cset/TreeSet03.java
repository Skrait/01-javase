package com.monkey1024.cset;

import java.util.TreeSet;

public class TreeSet03 {
    public static void main(String[] args) {
        TreeSet<Student> set= new TreeSet<>(new CompareByNameLength() );

        set.add(new Student("jack",28));
        set.add(new Student("andy",22));
        set.add(new Student("jack",27));
        set.add(new Student("jack",28));

        System.out.println(set);


    }
}
