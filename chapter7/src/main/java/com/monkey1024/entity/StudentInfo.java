package com.monkey1024.entity;

import java.time.LocalDate;

public class StudentInfo implements Comparable<StudentInfo>{

    //名称
    private String name;

    //性别 true男 false女
    private Boolean gender;

    //年龄
    private Integer age;

    //身高
    private Double height;

    //出生日期
    private LocalDate birthday;




    @Override
    public int compareTo(StudentInfo o) {
        return 0;
    }
}
