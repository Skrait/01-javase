package com.monkey1024.afile;

import java.io.FileInputStream;
import java.io.IOException;

/*
    将文件读取到JVM内存中
 */
public class FileInputStream01 {
    public static void main(String[] args) throws IOException {
        //FileInputStream fis = new FileInputStream("D:\\javacode\\01-javase\\chapter08\\src\\monkey1024.txt");
        FileInputStream fis = null;
        try {
        fis = new FileInputStream("chapter08\\src\\monkey1024.txt");

        /*读取monkey.txt文件内容
        执行一次就会读取一个，如一次读取a,b,c对应的ascii码值(可再做String强转)
        即调用3次read方法*/
            int v1 = fis.read();
            int v2 = fis.read();
            int v3 = fis.read();
            System.out.println(v1);
            System.out.println(v2);
            System.out.println(v3);
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
