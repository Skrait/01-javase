import java.math.BigDecimal;

public class BigDecimalTest1 {
    public static void main(String[] args) {
        System.out.println((2.0 - 1.1));
        BigDecimal bd1 = new BigDecimal("1.1");
        BigDecimal bd2 = new BigDecimal("2.0");

        System.out.println("使用传入字符串方式初始化BigDecimal：" + bd2.subtract(bd1));

        BigDecimal bd3 = BigDecimal.valueOf(2.0);
        BigDecimal bd4 = BigDecimal.valueOf(1.1);

        System.out.println("使用传入BigDecimal.valueOf()初始化BigDecimal：" + bd3.subtract(bd4));
    }
}
