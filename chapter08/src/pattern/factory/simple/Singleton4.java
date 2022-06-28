package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/4/19 16:10
 * 最终完美的写法。
 */
public class Singleton4 {

    private volatile static Singleton4 singleton4;
    private Singleton4(){};
    public static Singleton4 getSingleton(){// 1
        if (singleton4 == null){
            synchronized (Singleton4.class){
                if (singleton4 == null){// 2
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
