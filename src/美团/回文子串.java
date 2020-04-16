package 美团;

/*  回文子串（LC 647）
    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串（回文串是一个正读和反读都一样的字符串）。
    具有不同开始位置或结束位置的回文串，即使是由相同的字符组成，也会被计为是不同的子串。

    输入描述：
    输入仅包含一个字符串，长度不会超过 1000。

    输出描述：
    输出仅包含一个非负整数， 代表输入字符串有多少个回文子串。

    输入例子 1：
    abc
    输出例子 1：
    3

    输入例子 2：
    aaa
    输出例子 2：
    6
 */

import java.util.Scanner;
/*  二维 DP
        a   a   a
    a   T   T   T
    a       T   T
    a           T
 */
public class 回文子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
