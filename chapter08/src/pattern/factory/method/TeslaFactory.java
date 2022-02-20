package pattern.factory.method;

/**
 * Author Peekaboo
 * Date 2022/2/7 17:38
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
