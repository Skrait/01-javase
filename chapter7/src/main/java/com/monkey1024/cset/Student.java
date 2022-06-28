package com.monkey1024.cset;

public class Student implements Comparable{
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        keywordthis.name = name;
        keywordthis.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        keywordthis.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        keywordthis.age = age;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
