package 招商银行;

/*
    小招在玩一款游戏：在一个N层高的金字塔上，以金字塔顶为第一层，第i层有i个落点，每个落点有若干枚金币，在落点可以跳向左斜向下或向右斜向下的落点。
    若知道金字塔的层数N及每层的金币数量分布，请计算小招在本次游戏中可以获得的最多金币数量。

    输入描述:
    输入共有N + 1行(N ≤ 1024)，第一行为高度N，第二行至N + 1行 ，为该金字塔的金币数量分布。

    输出描述:
    输出金币数量。

    示例1
    输入
    5
    8
    3 8
    8 1 0
    4 7 5 4
    3 5 2 6 5
    输出
    31
 */

import java.util.Scanner;

public class 金币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] phy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                phy[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[N][N];
        for (int j = 0; j < N; j++) {
            dp[N - 1][j] = phy[N - 1][j];
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + phy[i][j];
            }
        }
        int res = dp[0][0];
        System.out.println(res);
    }
}
