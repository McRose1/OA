package 美团;

/*  字符串模式匹配（LC 44）
    给出两个字符串，分别是模式串 P 和目标串 T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。
    模式串中‘？’可以匹配目标串中的任何字符，模式串中的‘*’可以匹配目标串中的任何长度的串，模式串的其它字符必须和目标串的字符匹配。
    例如 P = a?b，T = acb，则 P 和 T 匹配。

    输入描述：
    输入第一行包含一个字符串p，（1 <= |p| <= 20）.
    输入第二行包含一个字符串t，（1 <= |t| <= 20）.

    输出描述：
    输出仅包含 0 和 1 的整数，0 表示 p 和 t 不匹配，1 表示 p 和 t 匹配。

    输入例子 1：
    a?b
    ab
    输出例子 1：
    0

    输入例子 2：
    a*b
    ab
    输出例子 2：
    1

    输入例子 3：
    a*b
    a(cb
    输出例子 3：
    1
 */

import java.util.Scanner;
//  二维 DP
public class 字符串模式匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String s = sc.nextLine();

        if (p == null || s == null) {
            System.out.println(0);
            return;
        }
        if (p.equals("*") || p.equals(s)) {
            System.out.println(1);
            return;
        }
        int pLen = p.length();
        int sLen = s.length();

        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        for (int pIdx = 1; pIdx <= pLen; pIdx++) {
            if (p.charAt(pIdx - 1) == '*') {
                dp[pIdx][0] = dp[pIdx - 1][0];
            }
        }

        for (int pIdx = 1; pIdx <= pLen; pIdx++) {
            for (int sIdx = 1; sIdx <= sLen; sIdx++) {
                if (p.charAt(pIdx - 1) == '?' || p.charAt(pIdx - 1) == s.charAt(sIdx - 1)) {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx - 1];
                } else if (p.charAt(pIdx - 1) == '*') {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx] || dp[pIdx][sIdx - 1];
                }
            }
        }
        int res = dp[pLen][sLen] ? 1 : 0;
        System.out.println(res);
    }
}
