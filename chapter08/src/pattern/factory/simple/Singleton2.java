package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/4/18 15:27
 * synchronized锁
 * 优化建议：只要在构建对象时同步没必要在获取使用对象时候也同步
 * 若实例对象还没有构建,多个线程会争抢锁
 * 但有个问题,多个线程都已进入语句2的时候,虽然只有一个线程抢到锁
 * 去执行语句3,一旦执行完,会有下一个线程立即进入语句3进行对象创建
 * 导致对象对象创建多次,再加一个判空操作即可解决,详见Singleton3
 */
public class Singleton2 {

    private Singleton2(){};
    private static Singleton2  instance = null;
    public static Singleton2 getSingleton(){// 1
        if (instance == null){// 2
            synchronized (Singleton2.class){// 3
                    instance = new Singleton2();// 4
            }
        }
        return instance;
    }
}
