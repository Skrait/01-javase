package abstract_class;

/**
 * @author Peekaboo
 * @date 2022年12月06日 15:41
 */
public class main {
    public static void main(String[] args) {
        A a = new A();
        a.area();
        B b = new B();
        b.area();

        Cat cat = new Cat();
        cat.eat();
        Dog dog = new Dog();
        dog.eat();
    }
}
