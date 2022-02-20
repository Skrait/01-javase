package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 22:37
 * 华为手机
 */
public class HUAWEIPhone implements IphoneProduct{
    @Override
    public void start() {
        System.out.println("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void callup() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为发短信");
    }
}
