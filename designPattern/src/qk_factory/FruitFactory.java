package qk_factory;

/**
 * @author Peekaboo
 * @date 2023年01月03日 16:40
 */
public abstract class FruitFactory<T extends Fruit> {
    /**
     * 这里直接用静态方法根据指定类型进行创建
     */
//    public static Fruit getFruit(String type){
//        switch (type){
//            case "苹果":
//                return new Apple();
//            case "橘子":
//                return new Orange();
//            default:
//                return null;
//        }
//    }

    public abstract T getFruit();//不同的水果工厂,通过此方法生产不同水果
}
