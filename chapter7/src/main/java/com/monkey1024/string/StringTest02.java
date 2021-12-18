package com.monkey1024.string;

import cn.hutool.db.Session;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTest02 {

    @Test
    public void dateTest1() {
        String nowTime = "202110";
        String batch = "0001";
        String format = String.format(nowTime + "%s", batch);
        System.out.println(format);
    }

    @Test
    public void dateTest2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Test
    public void uploadtest(){
        String originPath = "E:\\public\\KSHB_Files\\upload";
        String bizPath = "aqzj";
        String fullPath = originPath + File.separator + bizPath + File.separator;
        System.out.println(fullPath);

    }

    @Test
    public void uploadLocalEntity(){

    }
}
