package 华为;

/*  公共字串计算
    计算两个字符串的最大公共字串的长度，字符不区分大小写

    输入描述:
    输入两个字符串

    输出描述:
    输出一个整数

    示例1
    输入
    asdfas
    werasdfaswer
    输出
    6
 */

import java.util.Scanner;

public class 公共字串计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().toLowerCase();
        String s2 = sc.nextLine().toLowerCase();
        int res = longestCommon(s1, s2);
        System.out.println(res);
    }

    // DP
    private static int longestCommon(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == s1.charAt(0)) {
                dp[0][j] = 1;
                max = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    /*  Brute Force
    private static int longestCommon(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return longestCommon(s2, s1);
        }
        int max = 0;
        if (s2.contains(s1)) {
            return s1.length();
        } else {
            for (int start = 0; start < s1.length(); start++) {
                for (int end = start + 1; end <= s1.length(); end++) {
                    String target = s1.substring(start, end);
                    if (s2.contains(target)) {
                        max = Math.max(max, target.length());
                    }
                }
            }
        }
        return max;
    }

     */
}
