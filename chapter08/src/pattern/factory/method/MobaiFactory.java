package pattern.factory.method;

/**
 * Author Peekaboo
 * Date 2022/2/7 17:48
 */
public class MobaiFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new MoBai();
    }
}
