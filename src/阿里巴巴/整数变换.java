package 阿里巴巴;

/*
    开始有一个整数 n，你需要经过若干次操作，使 n 的值不小于 m。
    操作 1：将 n 更改为 2 * n，花费为 w2。
    操作 2：将 n 更改为 3 * n，花费为 w3。
    请输出需要的最小花费。

    输入：
    4
    1 6 2 3
    4 32 3 4
    2 1 1 2
    1 2147483647 1 4

    输出：
    5
    8
    0
    31
 */

import java.util.Scanner;

public class 整数变换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w2 = sc.nextInt();
            int w3 = sc.nextInt();
            if (n >= m) {
                System.out.println(0);
                continue;
            }
            if (m % n == 0 && (m / n) % 6 == 0) {
                int time = (m / n) / 6;
                System.out.println(time * (w2 + w3));
                continue;
            }
            int divide = m / n;
            int time2 = 0;
            while (divide > 0) {
                divide /= 2;
                time2++;
            }
            divide = m / n;
            int time3 = 0;
            while (divide > 1) {
                divide /= 3;
                time3++;
            }
            System.out.println(Math.min(time2 * w2, time3 * w3));
        }
    }
}
