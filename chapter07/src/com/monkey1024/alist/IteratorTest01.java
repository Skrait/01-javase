package com.monkey1024.alist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//使用For循环遍历集合
@SuppressWarnings({"rawtypes","unchecked"})
public class IteratorTest01 {

    public static void main(String[] args) {
        iterator02();
    }

    /*
    * 使用While循环*/
    public static void iterator02(){
        Collection c = new ArrayList();
        c.add(new Person("宋康",25));
        c.add(new Person("科比",42));
        c.add(new Person("泰森",54));

        //获取迭代器
        Iterator iter = c.iterator();
        while(iter.hasNext()){
            //向下转型
            Person p = (Person) iter.next();
            System.out.println(p.getName() + "。。。" + p.getAge());

        }

    }

    /*
     * 使用For循环*/
    public static void iterator01(){
        Collection c = new ArrayList();
        c.add(new Person("宋康",25));
        c.add(new Person("科比",42));
        c.add(new Person("泰森",54));


        for (Iterator iter = c.iterator();iter.hasNext();){
            //向下转型
            Person p = (Person) iter.next();
            System.out.println(p.getName() + "。。。" + p.getAge());
        }

    }
}
