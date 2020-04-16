package Shopee;

/*  LC62. Unique Paths
    笔试时居然忘记把 dp[0][0]初始化为 1。。。而是默认的 0
    结果 m = 1, n = 1 这个例子就是死活过不去
 */

import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        long[][] dp = new long[m][n];

        // 居然落了这一步！！！非常重要的 Corner case
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        long res = dp[m - 1][n - 1];

        System.out.print(res);
    }
}
