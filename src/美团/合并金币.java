package 美团;

/*  合并金币（类似 LC 5 和 LC 678 的难度中和版）
    有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。
    经过 N-1 次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
    其中，1 <= N <= 30，1 <= C[i] <= 100

    输入描述：
    第一行输入一个数字 N 表示有 N 堆金币
    第二行输入 N 个数字表示每堆金币的数量 C[i]

    输出描述：
    输出一个数字 S 表示最小的合并成一堆的成本

    输入例子 1：
    4
    3 2 4 1
    输出例子 1：
    20

    输入例子 2：
    30
    10 20 30 40 50 60 70 80 90 100 99 89 79 69 59 49 39 29 19 9 2 12 22 32 42 52 62 72 82 92
    输出例子 2：
    7307
 */

import java.util.Scanner;
//  二维 DP
public class 合并金币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        int[] preSum = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
            if (i == 0) {
                preSum[i] = money[i];
            } else {
                preSum[i] = preSum[i - 1] + money[i];
            }
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 单个数字不能合并
                if (i == j) {
                    dp[i][j] = 0;
                // 正好两个数字，合并就是两个数字的加和
                } else if (i + 1 == j) {
                    dp[i][j] = money[i] + money[j];
                // 3 个数字以上，就要引入分割点了
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    int sum = i == 0 ? preSum[j] : preSum[j] - preSum[i - 1];
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}

/*  Version 2:

        int[] money = new int[n + 1];
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            money[i] = sc.nextInt();
            if(i == 1) preSum[i] = money[i];
            else preSum[i] = preSum[i - 1] + money[i];
        }
        // 因为这题单个元素的结果为 0，所以就不用特定初始化，直接用 default 值
        int[][] dp = new int[n + 1][n + 1];
        for(int len = 2; len <= n; len++){
            for(int i = 1; i <= n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = preSum[j] - preSum[i - 1];
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println(dp[1][n]);
 */