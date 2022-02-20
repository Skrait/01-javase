package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 22:51
 */
public class HuaweiFactory implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new HUAWEIPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
