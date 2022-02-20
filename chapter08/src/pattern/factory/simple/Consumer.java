package pattern.factory.simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author Peekaboo
 * Date 2022/2/7 15:32
 *静态(也叫简单)工厂优点：
 * 通过以上代码可以看出来静态工厂的优点是封装了车子生产的过程，对于使用者来说，直接传入车子名字作为参数就可以获取想要的车子了。
 * 静态工厂缺点：
 * 扩展性差，倘若要想再生产其他品牌汽车的话，需要修改的代码比较多,即不符合开闭原则
 */
public class Consumer {
    public static void main(String[] args) {
//        Car wuLing = new WuLing();
//        Car tesla = new Tesla();

//    2.使用工厂创建
//        这样就能根据我们想要的名字调它即可
        Car wuLing = CarFactory.getCar("五菱");
        Car tesla = CarFactory.getCar("特斯拉");
        wuLing.name();
        tesla.name();


        //Calendar.getInstance()就是一个简单工厂
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
    }
}
