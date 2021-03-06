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
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            if(this.name.equals(p.getName()) && this.age == p.getAge()){
                return true;
            }
        }
        return false;
    }




}