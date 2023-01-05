package builder.demo02;

/**
 * @author Peekaboo
 * @date 2023年01月04日 17:07
 * 具体的建造者
 */
public class Worker extends Builder {

    private Product product;

    public Worker( ) {
        product = new Product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
