package pattern.factory.method;

/**
 * Author Peekaboo
 * Date 2022/2/7 17:40
 */
public class WuLingFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
