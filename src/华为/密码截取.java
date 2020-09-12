package 华为;

/*  密码截取
    Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
    但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
    比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
    因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
    Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？

    输入描述:
    输入一个字符串

    输出描述:
    返回有效密码串的最大长度

    示例1
    输入
    ABBA
    输出
    4
 */

import java.util.Scanner;

public class 密码截取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int max = 1;
        for (int i = 0; i < n; i++) {
            int oddLen = getLen(s, i, i);
            int evenLen = getLen(s, i, i + 1);
            max = Math.max(max, Math.max(oddLen, evenLen));
        }
        System.out.println(max);
    }

    private static int getLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

/*  DP (TLE)

        int[][] dp = new int[n][n];
        boolean[][] palindrome = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                if (len == 1) {
                    palindrome[i][i] = true;
                    dp[i][i] = 1;
                    continue;
                }
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        palindrome[i][j] = true;
                        dp[i][j] = 2;
                    } else {
                        if (len == 3) {
                            palindrome[i][j] = true;
                            dp[i][j] = 3;
                        } else {
                            if (palindrome[i + 1][j - 1]) {
                                dp[i][j] = dp[i + 1][j - 1] + 2;
                                palindrome[i][j] = true;
                            } else {
                                palindrome[i][j] = false;
                                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                            }
                        }
                    }
                } else {
                    palindrome[i][j] = false;
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
 */
