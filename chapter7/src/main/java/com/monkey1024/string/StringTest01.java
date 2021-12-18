package com.monkey1024.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringTest01 {

    @Test
    public void test1(){
        String s1 = "Kobe Bryant";
        int be = s1.indexOf("be");
        System.out.println(be);
    }

    @Test
    public void test2(){
        String s1 = "Kobe Bryant";
        String s = s1 + "/sys/hbzjhc/pfpg/createHBFSPD";
        System.out.println(s);
    }

    @Test
    public void test3(){
        String s1 = "√";
        String s2 = "×";
        String s = s1 + "/sys/hbzjhc/pfpg/createHBFSPD";
        System.out.println(s2 + s1);
    }

    //StringBuilder拼接测试
    @Test
    public void test4(){
        String [] s = new String[]{"SSHBPG_FS", "SSHBPG_FQ", "SSHBPG_FQ"};
        List<String> list = Arrays.asList(s);

        for (int i = 0; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i));
            sb.insert(0,"RWLX_");
            String s1 = sb.toString();
            System.out.println(s1);
        }
    }

    //字符串截取测试
    @Test
    public void test5(){
        String s = "RWXD_RWLX_HBZJ";
        String s1 = s.substring(s.lastIndexOf("_") + 1);
        System.out.println(s1);
    }

}
