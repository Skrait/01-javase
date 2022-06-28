package pattern.factory.simple;

/**
 * Author Peekaboo
 * Date 2022/4/18 9:30
 * 第一次调用才开始真正实例化Singleton对象，
 * 而不是程序启动之前就够建好等着你调用
 * 这种滞后的构建方式称为"懒加载"。
 */
public class Singleton {

    private Singleton(){};//构造器私有,让外部直接new一个实例对象
    private static Singleton instance = null;//初始化对象为null
    public static Singleton getInstance(){
        if (instance == null){
            instance = new  Singleton();
        }
        return instance;
    }
}
