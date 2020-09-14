package 华为;

/*  放苹果
    把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
    （用K表示）5，1，1和1，5，1 是同一种分法。

    输入
    每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。

    样例输入
    7 3

    样例输出
    8

    输入描述:
    输入两个int整数

    输出描述:
    输出结果，int型

    示例1
    输入
    7 3
    输出
    8
 */

import java.util.Scanner;

/*  DP
    令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
    1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
    2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上，即求(m-n，n)
 */
public class 放苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int j = 0; j <= N; j++) {
            dp[0][j] = 1;
            dp[1][j] = 1;
        }

        for (int i = 2; i <= M; i++) {
            for (int j = 2; j <= N; j++) {
                if (i >= j) {
                    // 1. 至少有一个盘子空着 dp[i][j - 1]
                    // 2. 所有盘子都有苹果 dp[i - j][j]
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[M][N]);
    }
}
