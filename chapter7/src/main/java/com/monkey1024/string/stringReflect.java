package com.monkey1024.string;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Peekaboo
 * Date 2022/8/7 16:12
 * 通过反射把 String 添加到 List<Integer> 中
 * 1、创建Integer类型的List集合，用于存放数据。
 * 2、使用对象名.getClass()方法获取Class对象。
 * 3、调用getMethod()方法获取指定的Method。
 * 4、调用invoke()方法将不同数据类型的数据添加到list集合中。
 *Invoke方法：动态调用Method类代表的方法。
 */
public class stringReflect {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        String s1 = "123a";
        List<Integer> integers = addObjectToList(list, s1);
        System.out.println(integers.get(0));

        // getClass方法作用：获取对象的属性、构造方法、继承关系等等许多

    }


    public static List<Integer> addObjectToList(List<Integer> list, Object o) throws Exception{

        Class<? extends List> class1 = list.getClass();
        Method method = class1.getMethod("add", Object.class);
        method.invoke(list,o);
        return list;

    }
}
