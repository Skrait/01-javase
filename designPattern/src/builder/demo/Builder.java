package builder.demo;

/**
 * @author Peekaboo
 * @date 2023年01月04日 15:15
 * 抽象的建造者,本身不负责造房，只定义造访的方法
 */
public abstract class Builder {

    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();

    //完工，得到产品
    abstract Product getProduct();
}
