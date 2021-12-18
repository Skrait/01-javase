package com.monkey1024.jpoly;

public class AnimalTest01 {
    public static void main(String[] args) {
        //以前创建对象的写法
        Cat cat = new Cat();
        cat.eat();

        //多态写法,父类型引用指向子类对象
        Animal a = new Cat();
        a.eat();
        System.out.println(a.num);
    }

}
