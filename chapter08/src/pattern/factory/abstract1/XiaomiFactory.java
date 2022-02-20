package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 22:49
 */
public class XiaomiFactory implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
