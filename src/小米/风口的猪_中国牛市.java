package 小米;

/*  风口的猪_中国牛市
    风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
    给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
    假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
    若两次交易机会都放弃，收益为0。
    设计算法，计算你能获得的最大收益。
    输入数值范围：2<=n<=100,0<=prices[i]<=100

    输入
    3,8,5,1,7,8
    输出
    12
 */

public class 风口的猪_中国牛市 {

    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;

        int[] first = new int[n];
        first[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            if (prices[i] > prices[i - 1]) {
                first[i] = Math.max(first[i - 1], prices[i] - min);
            } else {
                first[i] = first[i - 1];
            }
        }

        int[] second = new int[n];
        second[n - 1] = 0;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            if (prices[i] < prices[i + 1]) {
                second[i] = Math.max(second[i + 1], max - prices[i]);
            } else {
                second[i] = second[i + 1];
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, first[i] + second[i]);
        }
        return res;
    }
}
