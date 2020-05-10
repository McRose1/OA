package 趋势科技;

/*
            0, if x%50 = 0
    f(x) =  1, if x%50 = 1
            f(x-1) + 2*f(x-2), if x is others

    0   0
    1   1
    4   5
 */

import java.util.Scanner;
//  40%
public class 算法题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x % 50 == 0) {
            System.out.println(0);
            return;
        }
        if (x % 50 == 1) {
            System.out.println(1);
            return;
        }
        if (x < 0) {
            while (x < 0) {
                x += 50;
            }
        }
        int res = helper(x);
        System.out.println(res);
    }

    private static int helper(int x) {
        int[] dp = new int[50];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 50; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }
        return dp[x % 50];
    }
}
