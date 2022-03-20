package buystock;

import org.junit.Test;

/**
 * Author Peekaboo
 * Date 2022/3/18 13:05
 * LeetCode121题：买卖股票最佳时机
 * 给定一个任意数组prices，它的第i个元素表示一支给定股票第i天的价格
 * 你只能选择某一天买入这只股票，并选择未来某一天一个不同的日子卖出该股票
 * 返回你可以从这笔交易中获取的最大利润。如果不能获取任何利润，返回0。
 */
public class solution {

    /**
     * 1、记录【今天之前买入的最小值】min
     * 2、For循环下计算【今天卖出的最大获利max,今天之前买入的最小值】
     */

    @Test
    public void maxStockPrice() {
        int[] price = {7,1,5,3,6,4};
        int max = solution.maxStockProfit(price);
        System.out.println("最大收益为：" + max);
    }


    public static int maxStockProfit(int[] prices){
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length ; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
