package 滴滴;

/*  斐波那契蛇（AC 100%）
    小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
    小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
    34 21 13
     1  1  8
     2  3  5
    这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
    下面是n=4时的情况：
    987 610 377 233
     5   3   2  144
     8   1   1   89
     13  21  34  55
    小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。

    输入描述
    单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)

    输出描述
    输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。

    样例输入
    3
    样例输出
    34 21 13
    1 1 8
    2 3 5
 */

import java.util.Scanner;

public class 斐波那契蛇 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] matrix = new long[n][n];

        int x = 0, y = 0;
        int num = n * n;
        int round = 0;
        while (num != 0) {
            // right
            while (num > 0 && y < n - round) {
                matrix[x][y] = fibo(num);
                y++;
                num--;
            }
            y = n - round - 1;
            x++;

            // down
            while (num > 0 && x < n - round) {
                matrix[x][y] = fibo(num);
                x++;
                num--;
            }
            x = n - round - 1;
            y--;

            // left
            while (num > 0 && y >= round) {
                matrix[x][y] = fibo(num);
                y--;
                num--;
            }
            y = round;
            x--;

            round++;
            // up
            while (num > 0 && x >= round) {
                matrix[x][y] = fibo(num);
                x--;
                num--;
            }
            x = round;
            y++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    if (i == n - 1) {
                        System.out.print(matrix[i][j]);
                    } else {
                        System.out.println(matrix[i][j]);
                    }
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    private static long fibo(int n) {
        long[] dp = new long[n];
        if (n < 3) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}
