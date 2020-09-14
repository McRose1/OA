package Antra;

/*  字符串处理
    输入：
    aabbcd
    输出：
    aa*bb*c*d

    要求使用递归
 */

import java.util.Scanner;

public class 字符串处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        helper(s, 0, s.charAt(0));
        System.out.println(sb.toString());
    }

    private static StringBuilder sb = new StringBuilder();

    private static void helper(String s, int idx, char prev) {
        if (idx == s.length()) {
            return;
        }

        char cur = s.charAt(idx);
        if (cur != prev) {
            sb.append('*');
        }
        sb.append(cur);
        helper(s, idx + 1, cur);
    }
}
