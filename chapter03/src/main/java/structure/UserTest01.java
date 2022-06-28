package structure;

/**
 * @Author Peekaboo
 * Date 2022/6/24 10:59
 * 方法名与类名相同(注意大小写也要与类名一致)
 * 没有返回值类型
 * 没有void修饰
 * 方法体中没有return;
 * 如果一个类没有提供任何构造方法，系统默认提供无参数构造方法。
 * 如果一个类已经手动的提供了构造方法，那么系统不会再提供任何构造方法(包括无参)。
 * 构造方法支持重载。
 */
public class UserTest01 {

    public static void main(String[] args) {

        User u = new User("麻花疼", 40);
        System.out.println(u.getName());
        System.out.println(u.getAge());
    }
}
