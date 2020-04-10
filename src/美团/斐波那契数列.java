package 美团;

/*  斐波那契数列
    形如1，1，2，3，5，8，13，21，34，55 的数列，后一位是前面两位相加（斐波那契数列），写出函数要求找到第 N 位是多少，
    如：fib(3) => 3, fib(5) => 8，要求时间复杂度为 O(n)。

    输入描述：
    输入一个正整数 N(0<=N<=50)

    输出描述：
    输出第n项的数值

    输入例子 1：
    3
    输出例子 1：
    3

    输入例子 2：
    5
    输出例子 2：
    8
 */

import java.util.Scanner;
/*  一维 DP
    注意两点：
    1. 整形溢出：num = 50 肯定就溢出了，不能用 int，要用 long
    2. num = 0 的情况，直接返回 1
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        long res = dp[num];

        System.out.println(res);
    }
}
