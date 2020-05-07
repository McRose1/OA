package 浩鲸科技;

/*  排队问题
    有n个学生站成一排，每个学生有一个能力值，牛牛想从这n个学生中按照顺序选取k名学生，
    要求相邻两个学生的位置编号的差不超过d，使得这k个学生的能力值的乘积最大，你能返回最大的乘积吗？

    输入描述：
    每个输入包含1个测试用例。每个测试数据的第一行包含一个整数n (1 <= n <= 50)，表示学生的个数，
    接下来的一行，包含n个整数，按顺序表示每个学生的能力值ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k和d (1 <= k <= 10, 1 <= d <= 50)。

    输出描述：
    输出一行表示最大的乘积

    输入例子：
    3
    7 4 7
    2 50

    输出例子：
    49
 */

import java.util.Scanner;
/*  二维 DP
    dpp[i][j] 代表选 i+1 个人并以第 j 个人为结束时最大的乘积
 */
public class 排队问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();

        int[][] dp = new int[k][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = student[j];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (j - d >= 0) {
                    for (int x = j - d; x < j; x++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][x] * student[j]);
                    }
                } else {
                    for (int x = 0; x < j; x++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][x] * student[j]);
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[k - 1][i]);
        }
        System.out.println(res);
    }
}
