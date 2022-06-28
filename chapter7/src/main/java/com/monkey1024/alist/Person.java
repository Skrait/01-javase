package com.monkey1024.alist;


/**
 * Person类
 *
 */
public class Person {

    private String name;

    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        super();
        keywordthis.name = name;
        keywordthis.age = age;
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

    //重写toString方法
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        if(keywordthis == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            if(keywordthis.name.equals(p.getName()) && keywordthis.age == p.getAge()){
                return true;
            }
        }
        return false;
    }




}