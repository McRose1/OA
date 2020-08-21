package 滴滴;

/*  寻找丑数（剑指 Offer 49）
    把只包含因子2、3 和 5 的数称为丑数（Ugly Number）。例如 6、8 都是丑数、但 14 不是，因为它包含因子 7。
    习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。

    输入描述:
    整数N
    输出描述:
    第N个丑数

    示例：
    输入：
    6
    输出：
    6
 */

import java.util.Scanner;

public class 寻找丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N];
        // 相当于维护了 3 个指针
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[index2] * 2;
            int next3 = dp[index3] * 3;
            int next5 = dp[index5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == dp[index2] * 2) {
                index2++;
            }
            if (dp[i] == dp[index3] * 3) {
                index3++;
            }
            if (dp[i] == dp[index5] * 5) {
                index5++;
            }
        }
        System.out.println(dp[N - 1]);
    }
}
