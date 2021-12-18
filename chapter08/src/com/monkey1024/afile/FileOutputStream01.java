package com.monkey1024.afile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    将字符串写出到硬盘txt文件中
    字节流，以字节为单位进行传输
 */
public class FileOutputStream01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            //若该文件不存在，则会自动创建
            fos = new FileOutputStream("1024.txt");
            String msg = "Peekaboo";

            //将字符串转换成byte数组
            byte[] bytes = msg.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if (fos != null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
