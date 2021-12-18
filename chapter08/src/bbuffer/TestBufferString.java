package bbuffer;

import java.io.*;

public class TestBufferString {

    public static void main(String[] args) throws Exception {
        // 指定要读取文件的缓冲输入字节流
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\public\\hbzsk\\flfg\\两部委市场准入负面清单（2019 年版）.pdf"));
        File file = new File("E:\\public\\hbzsk\\flfg\\两部委市场准入负面清单（2019 年版）.pdf");
        if (file != null) {
            file.createNewFile();
        }
        // 指定要写入文件的缓冲输出字节流
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bb = new byte[1024];// 用来存储每次读取到的字节数组
        int n;// 每次读取到的字节数组的长度
        while ((n = in.read(bb)) != -1) {
            out.write(bb, 0, n);// 写入到输出流
        }
        out.close();// 关闭流
        in.close();
    }
}
