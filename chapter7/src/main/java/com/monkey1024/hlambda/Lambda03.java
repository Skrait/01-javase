package com.monkey1024.hlambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

//使用lambda表达式+forEach方法遍历集合(集合)
public class Lambda03 {

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach((Integer i) -> {
            //替代匿名内部类。
            System.out.println(i);
        });
    }

    @Test
    public void test2(){
        int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        for (int i : a) {
            System.out.print(a[i] + ", ");
        }
        System.out.println("");
        Arrays.sort(a);
        System.out.println(a);
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);//升序
        Integer[] nums = {4,2,8,1,5};
        Arrays.sort(nums,com);
        System.out.println(Arrays.toString(nums));
    }



    //对象::实例方法名
    @Test
    public void test4(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("haha");
        Consumer<String> con2 = System.out::println;
        con2.accept("haha");
    }
    //类::静态方法名
    @Test
    public void test5(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        com.compare(1,2);
        com2.compare(1,2);
    }
    //类::实例方法名
    @Test
    public void Test6(){
        BiPredicate<String,String> bp = (x, y) -> x.equals(y);
        bp.test("a","a");
        BiPredicate<String,String> bp2 = String::equals;
    }


}
