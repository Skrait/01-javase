//package com.monkey1024.alist;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///*泛型的好处，省去了强制类型转换*/
//
//public class GenericTest02 {
//    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//
//        list.add(new Person("宋康", 25));
//        list.add(new Person("宋", 25));
//
//        Iterator<Person> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Person p = ((Person)iterator.next());
//            System.out.println(p.getName() + p.getAge());
//        }
//
//        //2、增强For循环
//        for(Person s : list){
//            System.out.println("增强For循环打印的：" + s.getName() + s.getAge());
//        }
//
//    }
//}
