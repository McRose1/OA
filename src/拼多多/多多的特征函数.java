package 拼多多;

/*

 */

import java.util.Scanner;

public class 多多的特征函数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            int N = sc.nextInt();
            if (N == 1) {
                if (B % 3 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            long[] dp = new long[N + 1];
            dp[0] = A;
            dp[1] = B;
            for (int j = 2; j <= N; j++) {
                dp[j] = dp[j - 2] + dp[j - 1];
            }
            if (dp[N] % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
