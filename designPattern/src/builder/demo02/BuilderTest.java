package builder.demo02;

import org.testng.annotations.Test;

/**
 * @author Peekaboo
 * @date 2023年01月04日 17:07
 * 无指挥者版
 */
public class BuilderTest {

    @Test
    public void test1(){
        //服务员
        Worker worker = new Worker();
        //链式编程
        Product product1 = worker.buildA("全家桶").getProduct();
        Product product = worker.getProduct();
        System.out.println(product.toString());
    }

}
