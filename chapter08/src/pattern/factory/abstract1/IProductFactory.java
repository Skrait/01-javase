package pattern.factory.abstract1;

/**
 * Author Peekaboo
 * Date 2022/2/7 22:47
 * 产品工厂
 */
public interface IProductFactory {

    //生产手机
    IphoneProduct iphoneProduct();
    //生产路由器
    IRouterProduct routerProduct();

    //生产笔记本
//    INoteBook
}
