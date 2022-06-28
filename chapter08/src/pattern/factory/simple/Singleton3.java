package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/4/18 16:10
 * 在语句2中由于A线程已经将Singleton3初始化了
 * 所以不会进入语句2而是直接退出返回实例
 * 这种对 对象进行2次判空的操作叫做"双检锁"
 * 双检锁在日常开发中是一种很常见的同步线程手段
 */
public class Singleton3 {

    private Singleton3(){};
    private static Singleton3  instance;
    public static Singleton3 getSingleton(){// 1
        if (instance == null){
            synchronized (Singleton3.class){
                if (instance == null){// 2
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
