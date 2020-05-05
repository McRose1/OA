package 拼多多;

/*  数三角形
    给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。

    输入描述：
    第一行包含一个正整数n，表示平面上有n个点（n <= 100)
    第2行到第n + 1行，每行有两个整数，表示这个点的x坐标和y坐标。(所有坐标的绝对值小于等于100，且保证所有坐标不同）

    输出描述：
    输出一个数，表示能构成三角形的方案数。

    输入例子：
    4
    0 0
    0 1
    1 0
    1 1

    输出例子：
    4

    例子说明：
    4个点中任意选择3个都能构成三角形
 */

import java.util.Scanner;

public class 数三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        int count = 0;
        // 判断三个点是否能构成一个三角形
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!isLine(matrix, i, j, k)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isLine(int[][] matrix, int i, int j, int k) {
        // 如果两个点的 x 轴坐标相等，由于无法计算斜率，所以单独讨论第三个点的情况
        if (matrix[i][0] == matrix[j][0]) {
            return matrix[i][0] == matrix[k][0];
        } else if (matrix[i][0] == matrix[k][0]) {
            return matrix[i][0] == matrix[j][0];
        } else {
            // 通过计算斜率判断三个点是否共线
            double slope1 = (double) (matrix[i][1] - matrix[j][1]) / (matrix[i][0] - matrix[j][0]);
            double slope2 = (double) (matrix[i][1] - matrix[k][1]) / (matrix[i][0] - matrix[k][0]);
            return slope1 == slope2;
        }
    }
}
