package 乐鑫;

/*  开根号（LC 69 难度加大版）
    在没有任何数学库函数的情况下，求一个数 m 开 n 次方的结果。

    输入描述：
    每组输入只有1行，包括有一个正实数m和一个正整数n，其中1 <= n <= 32, 1 <= m <= 2^n。

    输出描述：
    输出只有一行，打印m开n次方的结果，小数点后面保留12位。

    输入例子：
    2 10

    输出例子：
    1.071773462536
 */

import java.util.Scanner;
//  Binary Search
public class 开根号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        int n = sc.nextInt();
        m = sqrt(m, n);
        System.out.println(String.format("%.12f", m));
    }

    private static double sqrt(double m, int n) {
        double left = 0;
        double right = m;
        while (left + 10e-12 < right) {
            double mid = left + (right - left) / 2;
            double temp = mid;
            for (int i = 0; i < n - 1; i++) {
                temp *= mid;
            }
            if (temp == m) return mid;
            else if (temp > m) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right > m / right) return left;
        else return right;
    }
}
