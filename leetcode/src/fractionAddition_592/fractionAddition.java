package fractionAddition_592;

/**
 * @Author Peekaboo
 * Date 2022/7/27 16:40
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class fractionAddition {

    public static void  main(String[] args) {
        fractionAddition("1/3-1/2");
    }

        public static String fractionAddition(String expression) {
            //先创建一个标识符判断第一个分数的正负
            boolean fushuFlag = expression.charAt(0) == '-';
            //将-替换成+-，方便分割，分割成一个个分数
            expression = expression.replace("-", "+-");
            String[] splits = expression.split("\\+");
            int[] fenzi = new int[splits.length];
            int[] fenmu = new int[splits.length];
            int sumfenmu = 1;
            //如果不为true就将第一个字符串转化为分数，并记录所有分母的乘积
            int i = 0;
            if (fushuFlag)
            {
                i = 1;
            }
            for (; i < splits.length; i++) {
                fenzi[i] = Integer.parseInt(splits[i].split("/")[0]);
                fenmu[i] = Integer.parseInt(splits[i].split("/")[1]);
                sumfenmu *= fenmu[i];
            }
            int sum = 0;
            i = 0;
            if (fushuFlag)
            {
                i = 1;
            }
            //将所有分数通分相加
            for (; i < splits.length; i++) {
                sum += sumfenmu / fenmu[i] * fenzi[i];
            }
            //求出公约数
            int yueshu = GCD(sum, sumfenmu);
            //进行约分，组成字符串
            return sum / yueshu + "/" + sumfenmu / yueshu;

        }

        public static int GCD(int m, int n) {
            m = Math.abs(m);
            n = Math.abs(n);
            int result = 0;
            while (n != 0) {
                result = m % n;
                m = n;
                n = result;
            }
            return m;
        }




}
