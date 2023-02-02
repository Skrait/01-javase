package other;

import org.junit.Test;

import static java.lang.Math.abs;

/**
 * @author Peekaboo
 * @date 2023年01月09日 15:11
 * 断言测试
 * 注：断言很少被使用，更少的是编写单元测试
 */
public class assertTest {

    @Test
    public void assertTest1(){
        double x = abs(-123.45);
        assert x >= 0 : "x must >= 0 but x = " + x;
        System.out.println(x);
    }
}
