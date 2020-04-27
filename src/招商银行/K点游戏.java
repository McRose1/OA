package 招商银行;

/*  K点游戏（LC 837）
    小招喵某日闲来无事，想验一下自己的人品，于是给自己定了一个游戏规则：
    这个游戏有三个因素：N，K，W
    游戏开始的时候小招喵有0点，之后如果发现自己手上的点不足K点，就随机从1到W的整数中抽取一个（包含1和W），抽到哪个数字的概率都是相同的。
    重复上述过程，直到小招喵获得了K或者大于K点，就停止获取新的点，这时候小招喵手上的点小于等于N的概率是多少？

    输入：N = 5， K = 1， W = 5
    输出：1.00000
    说明：开始有0点，不足1点，从[1,5]中随机取一个整数（一共5个数字，所以每个数字取到的概率都是1/5），获得后得分无论如何都大于了1点，停止，概率为1

    输入：N = 6， K = 1， W = 10
    输出：0.60000
    说明：开始有0点，不足1点，从[1,10]中随机取一个整数（一共10个数字，所以每个数字取到的概率都是1/10），获得后有6/10的概率小于6点，且满足大于1点的条件，概率为0.6

    输入描述：
    输入为3个整数，分别对应N，K，W，中间用空格隔开
    其中0 <= K <= N <= 10000，1 <= W <= 10000

    输出描述：
    输出为概率值，保留5位小数

    输入例子：
    21 17 10

    输出例子：
    0.73278
 */

import java.util.Scanner;

public class K点游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int W = sc.nextInt();

        if (K == 0 || N >= K - 1 + W) {
            double one = 1;
            System.out.println(String.format("%.5f", one));
            return;
        }
        if (N < K) {
            double zero = 0;
            System.out.println(String.format("%.5f", zero));
            return;
        }

        double[] dp = new double[N + 1];
        double Wsum = 1;
        double res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = Wsum / W;

            // all previous card could go to current i by only drawing one card
            if (i < K) {
                Wsum += dp[i];
            }
            // 达到游戏结束目标，将概率累加
            else {
                res += dp[i];
            }
            // move the window
            if (i - W >= 0) {
                Wsum -= dp[i - W];
            }
        }
        System.out.println(String.format("%.5f", res));
    }
}
