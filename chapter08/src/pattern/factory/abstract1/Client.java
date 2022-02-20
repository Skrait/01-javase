package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 23:02
 * 抽象工厂：围绕着一个超级工厂(IProductFactory)创建其他工厂。又称为其他工厂的工厂
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=======小米系列产品=======");
        //小米工厂
        XiaomiFactory xiaomiFactory = new XiaomiFactory();

        IphoneProduct iphoneProduct = xiaomiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaomiFactory.routerProduct();
        iRouterProduct.openWifi();


    }
}
