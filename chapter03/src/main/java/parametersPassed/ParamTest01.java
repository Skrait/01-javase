package parametersPassed;

/**
 * 3.7 参数传递和
 * @Author Peekaboo
 * Date 2022/6/22 17:15
 *
 */
public class ParamTest01 {

    public static void m1(int i) {
        i++;
        System.out.println("m1里的变量i=" + i);
    }

    public static void main(String[] args) {

        //布局变量
        int i = 10;

        //调用
        m1(i);

        System.out.println("main里面的变量i:" + i);
    }
}
