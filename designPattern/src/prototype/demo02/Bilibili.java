package prototype.demo02;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author Peekaboo
 * @date 2023年01月04日 17:44
 * 客户端,实现对象克隆
 */
public class Bilibili {

    @Test
    public void test01() throws CloneNotSupportedException{
        Date date = new Date();
        Video v1 = new Video("狂神说java", date);

        System.out.println("v1=>" + v1);
        System.out.println("v1 hashCode" + v1.hashCode());

        //从v1 克隆 v2
        Video v2 = (Video)v1.clone();
        date.setTime(111232323);
        System.out.println("v2=>" + v2);
        System.out.println("v2 hashCode" + v2.hashCode());

        v2.setName("clone狂神说java");
        System.out.println("v1=>" + v1);
        System.out.println("v2=>" + v2);
    }
}
