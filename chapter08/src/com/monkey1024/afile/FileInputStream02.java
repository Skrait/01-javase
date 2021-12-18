package com.monkey1024.afile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    将文件读取到JVM内存中
 */
public class FileInputStream02 {
    public static void main(String[] args) throws IOException {
        //FileInputStream fis = new FileInputStream("D:\\javacode\\01-javase\\chapter08\\src\\monkey1024.txt");
        FileInputStream fis = null;
        try {
        fis = new FileInputStream("chapter08\\src\\monkey1024.txt");

        //定义
        byte[] bytes = new byte[7];

        /*读取monkey.txt文件内容如果read返回方法是-1则说明读取完毕*/
        //保存当前读取字节
        int temp;
        while((temp = fis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,temp));
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null){
                    fis.close();//这里有可能发生空指针异常
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
