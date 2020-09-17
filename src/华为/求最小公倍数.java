package 华为;

/*  求最小公倍数
    正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。

    输入描述:
    输入两个正整数A和B。

    输出描述:
    输出A和B的最小公倍数。

    示例1
    输入
    5 7
    输出
    35
 */

import java.util.Scanner;

public class 求最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lcm = a * b / gcd(a, b);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
