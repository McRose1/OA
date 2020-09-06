package 华为;

/*  提取不重复的整数
    输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

    输入描述:
    输入一个int型整数

    输出描述:
    按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

    示例1
    输入
    9876673
    输出
    37689
 */

import java.util.Scanner;

public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[] used = new boolean[10];
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!used[c - '0']) {
                used[c - '0'] = true;
                sb.append(c);
            }
        }
        System.out.print(sb.toString());
    }
}
