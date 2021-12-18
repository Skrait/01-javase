package bbuffer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*使用缓冲流拷贝文件*/
public class FileCopyBuffer {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //(自动关闭jdk1.7)将要关闭的对象的所创建的代码放到try后面的小括号中
            //使用缓冲流包装(装饰 者)一下
            bis = new BufferedInputStream(new FileInputStream("chapter08/src/monkey1024.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("monkey.txt"));
            int temp;
            while((temp = bis.read()) != -1){
                //将数据写出到硬盘中
                bos.write(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    public static final Map<String, String> MODEL_MAPPER = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            put("SWAT", "1");
            put("Delt3D", "2");
            put("LSTM", "3");
            put("BP", "4");
        }
    };
    }

