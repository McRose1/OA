package 华为;

/*  字符串分隔
    •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
    •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
    输入描述:
    连续输入字符串(输入2次,每个字符串长度小于100)

    输出描述:
    输出到长度为8的新字符串数组

    示例1
    输入
    abc
    123456789
    输出
    abc00000
    12345678
    90000000
 */

import java.util.Scanner;

public class 字符串分隔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        helper(s1);
        helper(s2);
    }

    private static void helper(String s) {
        if (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            helper(s.substring(8));
        }  else if (s.length() > 0) {
            int zero = 8 - s.length();
            StringBuilder sb = new StringBuilder();
            while (zero-- > 0) {
                sb.append("0");
            }
            System.out.println(s + sb.toString());
        }
    }
}
