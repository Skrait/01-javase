package qk_factory;

public class AppleFactory extends FruitFactory<Apple> {  //苹果工厂，直接返回Apple，一步到位
    @Override
    public Apple getFruit() {
        return new Apple();
    }
}