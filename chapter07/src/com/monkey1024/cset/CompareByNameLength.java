package com.monkey1024.cset;

import java.util.Comparator;

//自定义比较器,先根据姓名长度排序
public class CompareByNameLength implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        //想根据姓名长度排序
        int num = s1.getName().length() - s2.getName().length();
        if (num == 0){
             num = s1.getName().compareTo(s2.getName());
            //若姓名一样则按照年龄
            if(num == 0){
                 num = s1.getAge() - s2.getAge();
            }
        }
        return num;
    }
}
