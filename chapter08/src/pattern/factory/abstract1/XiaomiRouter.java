package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 22:39
 */
public class XiaomiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("启动小米路由器WIFI");
    }

    @Override
    public void setting() {
        System.out.println("设置小米路由器");
    }
}
