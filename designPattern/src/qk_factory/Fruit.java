package qk_factory;

/**
 * @author Peekaboo
 * @date 2023年01月03日 16:37
 * 水果抽象类
 */
public abstract class Fruit {
    private final String name;

    public Fruit(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"@"+hashCode();   //打印一下当前水果名称，还有对象的hashCode
    }
}
