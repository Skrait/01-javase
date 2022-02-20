package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/2/7 15:36
 */
public class CarFactory {

    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new WuLing();
        }else if(car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }
}
