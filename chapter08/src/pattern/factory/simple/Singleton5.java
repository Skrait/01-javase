package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/4/19 17:56
 * 利用JVM类加载机制通过静态内部类实现单例模式
 */
public class Singleton5 {
    private Singleton5(){};

    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
