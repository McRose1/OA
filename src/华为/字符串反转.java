package 华为;

/*  字符串反转
    写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

    输入描述:
    输入N个字符

    输出描述:
    输出该字符串反转后的字符串

    示例1
    输入
    abcd
    输出
    dcba
 */

import java.util.Scanner;

public class 字符串反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.print(sb.toString());
    }
}
