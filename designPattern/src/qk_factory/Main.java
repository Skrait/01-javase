package qk_factory;

import java.util.function.Supplier;

/**
 * @author Peekaboo
 * @date 2023年01月03日 16:39
 */
public class Main {
    public static void main(String[] args) {
//        Apple apple = new Apple();
//        System.out.println(apple);

//        Fruit fruit = FruitFactory.getFruit("橘子");
//        System.out.println(fruit);
        test(new AppleFactory()::getFruit);
    }

    //此方法模拟吃掉一个水果
    private static void test(Supplier<Fruit> supplier){
        System.out.println(supplier.get() + "被吃掉了,真好吃");
    }
}
