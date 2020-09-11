package 天翼云;

/*  输出第N个丑数 (LC 264)
    只包含因子 2、3 和 5 的数称作丑数
    1 是第一个丑数

    输入包括一个整数 N（1 <= N <= 1500）

    每输入一个测试数据，就输出第 N 个丑数

    示例 1：
    输入：
    3
    输出:
    3

    示例 2：
    输入：
    7
    输出：
    8
 */

import java.util.Scanner;

public class 输出第N个丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        if (N == 3) {
            System.out.println(3);
            return;
        }
        N -= 3;
        int num = 4;
        while (N > 0) {
            if (isUgly(num)) {
                N--;
            }
            num++;
        }
        System.out.println(--num);
    }

    private static boolean isUgly(int n) {
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
