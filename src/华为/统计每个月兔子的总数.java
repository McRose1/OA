package 华为;

/*  统计每个月兔子的总数
    有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
    假如兔子都不死，问每个月的兔子总数为多少？

    输入描述:
    输入int型表示month

    输出描述:
    输出兔子总数int型

    示例1
    输入
    9
    输出
    34
 */

import java.util.Scanner;

public class 统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int[] dp = new int[month];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < month; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[month - 1]);
    }
}
