package com.monkey1024.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Peekaboo
 * Date 2022/8/17 22:21
 */
public class subString {


    @Test
    public void test1(){
        String str = "姆爷1.jpg";
        String sufix = str.substring(str.lastIndexOf("."));
        String prefix = str.substring(0,str.lastIndexOf("."));
    }

    @Test
    public void test2(){
        String str = "a,b,c";
        List<String> result = Arrays.asList(str.split(","));
        //System.out.println(result);
    }


//    @Test



}
