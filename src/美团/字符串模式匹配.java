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

public class 字符串模式匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pat = sc.nextLine();
        String dest = sc.nextLine();

        int patIdx = 0;
        int destIdx = 0;
        while (patIdx < pat.length() && destIdx < dest.length()) {
            if (pat.charAt(patIdx) == dest.charAt(destIdx) || pat.charAt(patIdx) == '?') {
                patIdx++;
                destIdx++;
            // '*' 可以匹配 0 个字符、1 个字符或多个字符
            } else if (pat.charAt(patIdx) == '*') {
                dfs(pat, dest, patIdx, destIdx);
            }
        }
    }

    private static void dfs(String pat, String dest, int patIdx, int destIdx) {

    }
}
