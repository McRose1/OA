package 美团;

/*  外卖小哥的保温箱
    在最短时间内用最少的保温箱将货物装好。
    1. 每个货物占用空间都一模一样
    2. 外卖小哥保温箱的最大容量是不一样的，每个保温箱由两个值描述：保温箱的最大容量 bi，当前已有货物个数 ai, (ai <= bi)
    3. 货物转移的时候，不必一次性全部转移，每转移一件货物需要花费 1 秒的时间

    输入描述：
    第一行包含 n 个正整数（1<=n<=100）表示保温箱的数量
    第二行有 n 个正整数 a1, a2, ... , n (1<=ai<=100)
    ai 表示第 i 个保温箱的已有货物个数
    第三行有 n 个正整数 b1, b2, ..., bn (1<=bi<=100)，bi 表示第 i 个保温箱的最大容量
    显然，每一个 ai <= bi

    输出描述：
    输出为两个整数 k 和 t，k 表示能容纳所有货物的保温箱的最少个数，t 表示将所有货物转移到这 k 个保温箱所花费的最少时间，单位为秒。

    输入例子 1：
    4
    3 3 4 3
    4 7 6 5
    输出例子 1：
    2 6
    例子说明 1：
    我们可以把第一个保温箱中的货物全部挪到第二个保温箱中,花费时间为3秒,此时第二个保温箱剩余容量为1,
    然后把第四个保温箱中的货物转移一份到第二个保温箱中,转移最后两份到第三个保温箱中.总花费时间也是3秒,所以最少保温箱个数是2,最少花费时间为6秒

    输入例子 2：
    2
    1 1
    100 100
    输出例子 2：
    1 1

    输入例子 3：
    5
    10 30 5 6 24
    10 41 7 8 24
    输出例子 3：
    3 11
 */

import java.util.Scanner;

// 二维 DP
public class 外卖小哥的保温箱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] food = new int[n];
        int[] capacity = new int[n];

        int max_food = 0;
        int max_capacity = 0;
        for (int i = 0; i < n; i++) {
            food[i] = sc.nextInt();
            max_food += food[i];
        }
        for (int i = 0; i < n; i++) {
            capacity[i] = sc.nextInt();
            max_capacity += capacity[i];
        }
        int[][] dp = new int[max_capacity + 1][2];
        dp[0][0] = 0;
        // 初始化容量为i的保温箱的个数为n,货物为0
        for (int i = 1; i < max_capacity + 1; i++) {
            dp[i][0] = n;
            dp[i][1] = 0;
        }
        // 找到这n个保温箱能够装的所有货物可能性
        for (int k = 1; k < n + 1; k++) {
            for (int i = max_capacity; i >= 0; i--) {
                // 更新保温箱
                int count = dp[Math.max(i - capacity[k - 1], 0)][0];
                int weight = dp[Math.max(i - capacity[k - 1], 0)][1];

                if (dp[i][0] < count + 1)
                    continue;
                else if (dp[i][0] > count + 1) {
                    dp[i][0] = count + 1;
                    dp[i][1] = weight + food[k - 1];
                }
                // 如果保温箱数目相等，选择货物多的
                else {
                    if (dp[i][1] < weight + food[k - 1])
                        dp[i][1] = weight + food[k - 1];
                }
            }
        }

        int k = n;
        int t = max_capacity;
        // 找到能够装完所有货物的最小保温箱个数，且已装有货物最多
        for (int i = max_food; i < max_capacity + 1; i++) {
            if (dp[i][0] < k) {
                k = dp[i][0];
                t = dp[i][1];

            } else if (dp[i][0] == k) {
                if (dp[i][1] > t) {
                    t = dp[i][1];

                }
            }
        }
        System.out.println(k + " " + (max_food - t));
    }
}
