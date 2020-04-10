package 美团;

/*  迷宫寻路
    给定一个包含非负整数的 M X N 迷宫，请找出一条从左上角到右下角的路径，使得路径上的数字总和最小。每次只能向下或者向右移动一步。

    输入描述：
    第一行包含两个整数 M 和 N，以空格隔开，1<=M<=10, 1<=N<=10。
    接下来的 M 行中，每行包含 N 个数字。

    输出描述：
    找出总和最小的路径，输出路径上的数字总和。

    输入例子：
    3 3
    1 3 1
    1 5 1
    4 2 1

    输出例子：
    7
 */

import java.util.Scanner;
//  二维 DP
public class 迷宫寻路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[M][N];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int res = dp[M - 1][N - 1];

        System.out.println(res);
    }
}
