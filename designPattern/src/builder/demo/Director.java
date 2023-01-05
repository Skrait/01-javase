package builder.demo;

/**
 * @author Peekaboo
 * @date 2023年01月04日 15:33
 * 指挥：核心。负责指挥构建一个工程，工程如何构建，由它决定
 */
public class Director {

    //只会工人按顺序构建房子
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }
}
