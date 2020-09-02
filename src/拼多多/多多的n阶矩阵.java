package 拼多多;

/*  多多的n阶矩阵

    输入描述：一个数字 n，3 < n < 200

    示例 1：
    输入：
    4
    输出：
    0 2 1 0
    3 0 0 8
    4 0 0 7
    0 5 6 0

    示例 2：
    输入：
    5
    输出：
    0 2 0 1 0
    3 0 0 0 8
    0 0 0 0 0
    4 0 0 0 7
    0 5 0 6 0
 */

import java.util.Scanner;

public class 多多的n阶矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n % 2 == 1 && (i == n / 2 || j == n / 2)) {
                    continue;
                } else if (i == j) {
                    continue;
                } else if (i == n - j - 1) {
                    continue;
                } else if (i < n / 2 - 1 && j >= n / 2 && j < n - 1 && (n - j > i))  {
                    matrix[i][j] = 1;
                } else if (i < n / 2 - 1 && j < n / 2 && j > 0 && j >= i) {
                    matrix[i][j] = 2;
                } else if (i < n / 2 && i >= 1 && j <= n / 2 - 1) {
                    matrix[i][j] = 3;
                } else if (i < n / 2 && i >= 1 && j >= n / 2 + 1) {
                    matrix[i][j] = 8;
                } else if (i >= n / 2 && i < n - 1 && j <= n / 2 - 1 && (n - i) > j) {
                    matrix[i][j] = 4;
                } else if (i >= n / 2 && i < n - 1 && j >= n / 2 + 1 && j >= i) {
                    matrix[i][j] = 7;
                } else if (i > n / 2 && j < n / 2  && j > 0 && (n - i) <= j) {
                    matrix[i][j] = 5;
                } else if (i > n / 2 && j >= n / 2 && j < n - 1) {
                    matrix[i][j] = 6;
                }
            }
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
}
