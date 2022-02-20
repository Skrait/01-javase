package pattern.factory.method;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author Peekaboo
 * Date 2022/2/7 17:45
 */
public class Consumer {

    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        Car Car3 = new MobaiFactory().getCar();

        car.name();
        car2.name();
        Car3.name();

    }
}
