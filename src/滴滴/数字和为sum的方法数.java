package 滴滴;

/*  数字和为sum的方法数
    给定一个有 n 个正整数的数组 A 和一个整数 sum，求选择数组中 A 中部分数字和为 sum 的方案数。
    当两种选取方案有一个数字的下标不一样，我们就认为是不同的组成方案。

    输入描述:
    输入为两行:
     第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
     第二行为n个正整数A[i](32位整数)，以空格隔开。
    输出描述:
    输出所求的方案数

    示例：
    输入：
    5 15
    5 5 10 2 3
    输出：
    4
 */

import java.util.Scanner;

/*  DP（0-1背包）

 */
public class 数字和为sum的方法数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
