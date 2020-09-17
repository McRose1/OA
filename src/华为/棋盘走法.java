package 华为;

/*  棋盘走法
    请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
    总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。

    输入描述:
    输入两个正整数

    输出描述:
    返回结果

    示例1
    输入
    2
    2
    输出
    6
 */

import java.util.Scanner;

public class 棋盘走法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m][n]);
    }
}
