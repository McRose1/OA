package Shopee;

import java.util.Arrays;
import java.util.Scanner;

/*  Shopee的办公室
    shopee 的办公室非常大，小虾同学的位置在右上角，而大门却在左下角，可以把所有位置抽象为一个网格（门口的坐标为 0，0），
    小虾同学很聪明，每次只向上，或者向右走，因为这样最容易接近目的地，但是小虾同学不想让自己的 boss们看到自己。
    他决定研究一下如果他不通过 boss们的位置，他可以有多少种走法？

    输入描述：
    第一行 x, y, n（0<x<=30, 0<y<=30, 0<=n<=20）表示x, y小虾的座位坐标，n 表示 boss 的数量（n<=20）
    接下来有 n 行，表示 boss 们的坐标（0<=xi<=x, 0<=yi<=y，不会和小虾位置重合）
    x1, y1
    x2, y2
    ......
    xn, yn

    输出描述：
    输出小虾有多少种走法

    输入例子：
    3 3 2
    1 1
    2 2
    输出例子：
    4
 */
//  二维 DP
public class Shopee的办公室 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt() + 1;
        int col = sc.nextInt() + 1;
        int boss = sc.nextInt();

        long[][] dp = new long[row][col];
        for (long[] num : dp) {
            Arrays.fill(num, -1);
        }

        for (int i = 0; i < boss; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            dp[r][c] = 0;
        }
        if (dp[0][0] == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i < row; i++) {
            if (dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            }
        }
        for (int j = 1; j < col; j++) {
            if (dp[0][j - 1] == 0) {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < row; i++) {
            if (dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < col; j++) {
            if (dp[0][j - 1] == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        long res = dp[row - 1][col - 1];
        System.out.println(res);
    }
}

/*  Version 2（问题复杂化了有点）

        for (int i = 0; i < boss; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            dp[r][c] = -1;
        }
        if (dp[0][0] == -1) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < row; i++) {
            if (dp[i - 1][0] == -1) {
                dp[i][0] = -1;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < col; j++) {
            if (dp[0][j - 1] == -1) {
                dp[0][j] = -1;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (dp[i][j] != -1) {
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (dp[i - 1][j] == -1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }

         */