package com.monkey1024.afile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis  = new FileInputStream("chapter08/src/monkey1024.txt");
            fos = new FileOutputStream("monkey.txt");

            //定义byte数组来读取字节数据
            byte[] bytes = new byte[3];
            int length;
            //数据读到byte数组当中并返回剩下未读取的长度
            while ((length = fis.read(bytes)) != -1){
                System.out.println(3);
                //参数1：把读进来的byte数组数据写出去，从0元素开始读，
                fos.write(bytes,0,3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
